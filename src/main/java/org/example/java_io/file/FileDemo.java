package org.example.java_io.file;

import java.io.File;
import java.io.IOException;

/**
 * 2. File 类基本 API
 *
 * @author lifei
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        File f = new File("demo");
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
    }
}
