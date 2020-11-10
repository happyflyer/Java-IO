package org.example.java_io.raf;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * 3. RandomAccessFile 类使用
 *
 * @author lifei
 */
public class RafDemo {
    public static void main(String[] args) throws IOException {
        File dir = new File("src/main/resources/raf");
        if (!dir.exists()) {
            dir.mkdir();
        }
        File file = new File(dir, "raf.dat");
        if (!file.exists()) {
            file.createNewFile();
        }

        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        System.out.println(raf.getFilePointer());

        raf.write('A');
        raf.write('B');
        System.out.println(raf.getFilePointer());

        int i = 0x7fffffff;
        raf.write(i >>> 24);
        raf.write(i >>> 16);
        raf.write(i >>> 8);
        raf.write(i);
        System.out.println(raf.getFilePointer());

        raf.writeInt(i);
        System.out.println(raf.getFilePointer());

        String s = "中";
        byte[] bytes = s.getBytes();
        raf.write(bytes);
        System.out.println(raf.getFilePointer());

        System.out.println(raf.length());

        raf.seek(0);
        System.out.println(raf.getFilePointer());

        byte[] buf = new byte[(int) raf.length()];
        raf.read(buf);
        System.out.println(Arrays.toString(buf));

        for (byte b: buf) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();

        String s1 = new String(buf);
        System.out.println(s1);

        raf.close();
    }
}
