package org.example.java_io.bytes;

import java.io.*;

/**
 * 4. 字节流的使用
 * DataInputStream
 * DataOutputStream
 *
 * @author lifei
 */
public class DataStreamUtil {
    static void writeData(String fileName) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName));
        dos.writeInt(10);
        dos.writeInt(-10);
        dos.writeLong(10L);
        dos.writeDouble(10.5);
        // 采用 UTF-8 编码写出
        dos.writeUTF("中国");
        // 采用 UTF-6be 编码写出
        dos.writeChars("中国");
        dos.close();
    }

    static void readData(String fileName) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(fileName));
        System.out.println(dis.readInt());
        System.out.println(dis.readInt());
        System.out.println(dis.readLong());
        System.out.println(dis.readDouble());
        System.out.println(dis.readUTF());
        System.out.println(dis.readChar());
        System.out.println(dis.readChar());
        dis.close();
    }
}
