package org.example.java_io.serial;

import java.io.*;

/**
 * @author lifei
 */
public class ObjectSerialDemo {
    static void saveObject(String fileName) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
        Student stu1 = new Student("10001", "张三", 20);
        oos.writeObject(stu1);
        oos.flush();
        oos.close();
    }

    static void readObject(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
        Student stu1 = (Student) ois.readObject();
        System.out.println(stu1);
    }
}
