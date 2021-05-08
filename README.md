# [Java IO](https://github.com/happyflyer/Java-IO)

## 1. 编码问题

- **GBK** 编码中文占用 **2** 个字节，英文占用 **1** 个字节
- **UTF-8** 编码中文占用 **3** 个字节，英文占用 **1** 个字节
- java 是双字节编码，**utf-16be** 编码占用 **2** 个字节，英文占用 **2** 个字节

当**字节序列**是某种**编码方式**时，这时候想把字节序列编程字符串，也必须使用相同的编码方式，否则会出现**乱码**。

**文本文件**在计算机中存储的就是字节序列。可以是任意编码的字节序列。

如果我们在中文机器上直接**创建**文本文件，那么该文本文件只认识**ANSI 编码**。

`联通`、`联` 是一种巧合，他们正好符合了 UTF-8 编码的规则。

## 2. File 类使用

`java.io.File` 用于表示文件或者目录。`File` 类只能用于表示文件（目录）的信息（名称、大小等），不能用于文件内容的访问。

### 2.1. 构造函数

```java
File f = new File(String args0);
File f = new File(URI args0);
File f = new File(File args0, String args1);
File f = new File(String args0, String args1);
```

### 2.2. 基本 API

```java
File f = new File("c:/demo");
System.out.println(f.exists());
if (!f.exists()) {
    f.mkdir();
    // 创建多级目录
    f.mkdirs();
    System.out.println("f created");
} else {
    f.delete();
    System.out.println("f deleted");
}
System.out.println(f.isDirectory());
System.out.println(f.isFile());
System.out.println(f.getPath());
System.out.println(f.getName());
System.out.println(f.getParent());
```

```java
File f1 = new File("hello.txt");
if (!f1.exists()) {
    f1.createNewFile();
    System.out.println("f1 created");
} else {
    f1.delete();
    System.out.println("f1 deleted");
}
System.out.println(f1);
System.out.println(f1.getAbsolutePath());
System.out.println(f1.getPath());
System.out.println(f1.getName());
System.out.println(f1.getParent());
System.out.println(f1.getParentFile());
```

```java
static void listDirectory(File dir) {
    if (!dir.exists()) {
        throw new IllegalArgumentException("目录" + dir + "不存在！");
    }
    if (!dir.isDirectory()) {
        throw new IllegalArgumentException(dir + "不是目录！");
    }
    String[] filenames = dir.list();
    if (filenames != null && filenames.length > 0) {
        for (String string : filenames) {
            System.out.println(string);
        }
    }
    File[] files = dir.listFiles();
    if (files != null && files.length > 0) {
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println(file.getAbsolutePath());
                listDirectory(file);
            } else {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}
```

## 3. RandomAccessFile 类使用

**RandomAccessFile** 类是 Java 提供的对文件内容的访问类。既可以读文件，也可以写文件。可以随机访问文件，可以访问文件的任意位置。

### 3.1. Java 文件模型

在硬盘上的文件是 Byte Byte Byte 存储的，是数据的集合。

### 3.2. 打开文件的两种模式

- `r`
- `rw`

### 3.3. 构造函数

```java
RandomAccessFile raf = new RandomAccessFile(file, "rw");
```

### 3.4. 文件指针

打开文件后，文件指针 `int pointer = 0;`

### 3.5. 读/写方法

`write()`方法只能写一个字节（后 8 位）。也就是说，如果要写一个`int`，需要写 4 次，同时指针指向下一个位置，准备再次写入。

```java
raf.write(int a);
```

`read()`只读一个字节。

```java
int b = raf.read();
```

文件读写完成后一定要关闭。

```java
raf.close();
```

## 4. 字节流的使用

### 4.1. 输入输出流

- 输入流
- 输出流

### 4.2. 输入输出单位

- 字节流
- 字符流

### 4.3. 两个抽象父类

- **InputStream**：抽象了应用程序读取数据的方式
- **OutputStream**：抽象了应用程序写出数据的方式

### 4.4. 文件读写结束

- `EOF`
- `-1`

### 4.5. 输入流的基本方法

```java
// 读取一个字节，无符号填充到 int 的低 8 位，-1 是 EOF
int b = in.read();
```

```java
// 读取数据直接填充到字节数组 buf
in.read(byte[] buf);
```

```java
in.read(byte[] buf, int start, int size);
```

### 4.6. 输出流的基本方法

```java
// 写出 1 个 byte 到流，b 的低 8 位
out.write(int b);
```

```java
// 将字节数组 buf 写入到流
out.write(byte[] buf);
```

```java
out.write(byte[] buf, int start, int size);
```

### 4.7. FileXXX 子类

- **FileInputStream**：具体实现了在文件上读取数据
- **FileOutputStream**：具体实现了向文件中写出 Byte 数据的方法

### 4.8. DataXXX 子类

- **DataInputStream**：对流功能的扩展，可以更加方便地读取 `int` / `long` / 字符型等类型数据
- **DataOutputStream**：对流功能的扩展，可以更加方便地写出 `int` / `long` / 字符型等类型数据

实际上就是**包装**，底层实现还是写字节的方式。

#### 4.8.1. DataOutputStream

- `writeInt()`
- `writeDouble()`
- `writeUTF()`
- `writeChar()`
- `writeChars()`

#### 4.8.2. DataInputStream

- `readInt()`
- `readDouble()`
- `readUTF()`
- `readChar()`

### 4.9. BufferedXXX 子类

- **BufferedInputStream**
- **BufferedOutputStream**

这两个流类为 I/O 提供了带缓冲区的操作，一般打开文件进行写入或读取操作时，都会加上缓冲，这种流模式提高了 I/O 性能（主要是输入输出性能）。

## 5. 字符流的使用

### 5.1. 基本概念

- 编码问题
- 文本：`char` 是 **16** 为无符号整数，是字符的 Unicode 编码（双字节编码）
- 文件：`Byte` `Byte` `Byte` 的数据序列
- 文本文件：文本（char）按照某种编码方案（如 `UTF-8`、`UTF-16be`、`GBK`）序列化为 `Byte` 的存储结果

### 5.2. 字符流的抽象类

- **Reader**：输入流
- **Writer**：输出流

字符的处理，一次处理一个字节。**字符**的底层仍然是**字节序列**。

### 5.3. 字符流的基本实现

- **InputStreamReader**：完成 `Byte` 流解析为 `char` 流，按照指定编码解析
- **OutputStreamWriter**：提供 `char` 流到 `Byte` 流，按照指定编码处理

### 5.4. FileXXX 子类

- **FileReader**
- **FileWriter**

### 5.5. BufferedXXX 子类

- **BufferedReader**：`String line = br.readLine();`
- **BufferedWriter**：`bw.write(line);`
- **PrintWriter** + **Buffer**

## 6. 对象序列化

### 6.1. 概念

- **对象序列化**：将 `Object` 转换为 `Byte` 序列
- **对象反序列化**：将 `Byte` 序列转换为 `Object`

### 6.2. 序列化流

- **ObjectOutputStream**：`writeObject()`
- **ObjectInputStream**：`readObject()`

### 6.3. 序列化接口

对象必须实现序列化接口，才能进行序列化，否则出现异常。

`Serializable` 接口没有任何方法，只是一个标准。

### 6.4. transient 关键字

`transient` 修饰后的元素，该元素不会进行 JVM 默认的序列化。但是也可以自己完成这个元素的序列化。

```java
public class Student implements Serializable {
    private String stuNo;
    private transient String stuName;
    private transient int stuAge;

    // ...

    private void writeObject(ObjectOutputStream s)
            throws IOException {
        // 把 JVM 默认能序列化的元素进行序列化
        s.defaultWriteObject();
        // 自己完成其他元素的序列化
        s.writeObject(stuName);
        s.writeInt(stuAge);
    }

    private void readObject(ObjectInputStream s)
            throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.stuName = (String) s.readObject();
        this.stuAge = s.readInt();
    }
}
```

`ArrayList` 自定义元素的序列化，只让有效的元素进行序列化，调高序列化的效率。

### 6.5. 序列化中子父类构造函数问题

一个类实现了 `Serializable` 接口，那么其子类都可以进行序列化。

序列化时，递归调用父类的构造函数。

反序列化时，如果其父类没有实现 `Serializable` 接口，那么父类的构造函数会被调用，如果其父类实现了 `Serializable` 接口，那么我们将看不到父类构造函数调用过程。
