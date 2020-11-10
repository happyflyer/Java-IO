package org.example.java_io.serial;

import java.io.*;

class ObjectSerialDemo2 {
    static void saveObject(String fileName) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
        // Foo2 foo2 = new Foo2();
        // oos.writeObject(foo2);
        Bar2 bar2 = new Bar2();
        oos.writeObject(bar2);
        oos.flush();
        oos.close();
    }

    static void readObject(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
        // Foo2 foo2 = (Foo2) ois.readObject();
        // System.out.println(foo2);
        Bar2 bar2 = (Bar2) ois.readObject();
        System.out.println(bar2);
    }
}
