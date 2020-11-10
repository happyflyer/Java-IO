package org.example.java_io.bytes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 4. 字节流的使用
 * FileInputStream
 * FileOutputStream
 *
 * @author lifei
 */
class FileStreamUtil {
    /**
     * 按字节读文件，不带缓冲，按照十六进制输出到控制台，每输出 10 个 byte 换行
     *
     * @param fileName 读取文件
     */
    static void printHex(String fileName) throws IOException {
        // 把文件作为字节流进行读操作
        FileInputStream in = new FileInputStream(fileName);
        int b;
        int i = 1;
        while ((b = in.read()) != -1) {
            if (b <= 0xf) {
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(b) + " ");
            if (i++ % 10 == 0) {
                System.out.println();
            }
        }
        in.close();
    }

    /**
     * 按字节读文件，带缓冲
     *
     * @param fileName 读取文件
     * @throws IOException IO异常
     */
    static void printHexByByteArray(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        // 20k
        byte[] buf = new byte[20 * 1024];
        int bytes;
        int j = 1;
        while ((bytes = in.read(buf, 0, buf.length)) != -1) {
            for (int i = 0; i < bytes; i++) {
                if (Byte.toUnsignedInt(buf[i]) <= 0xf) {
                    System.out.print("0");
                }
                System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");
                if (j++ % 10 == 0) {
                    System.out.println();
                }
            }
        }
    }

    /**
     * 按字节写文件
     *
     * @param fileName 写入文件
     * @throws IOException IO异常
     */
    static void writeByte(String fileName) throws IOException {
        // 如果该文件不存在，则直接创建，如果存在，则删除后创建
        FileOutputStream out = new FileOutputStream(fileName);
        // 如果该文件不存在，则直接创建，如果存在，在文件后面直接追加内容
        // FileOutputStream out = new FileOutputStream(fileName, true);
        out.write('A');
        out.write('B');
        int i = 10;
        out.write(i >>> 24);
        out.write(i >>> 16);
        out.write(i >>> 8);
        out.write(i);
        byte[] gbkBytes = "中国".getBytes("gbk");
        out.write(gbkBytes);
        out.close();
    }

    /**
     * 按字节拷贝文件，带缓冲
     *
     * @param srcFile 源文件
     * @param desFile 目的地文件
     * @throws IOException IO异常
     */
    static void copyFile(File srcFile, File desFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("srcFile: " + srcFile + "文件不存在！");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException("srcFile: " + srcFile + "不是文件！");
        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(desFile);
        // 8k
        byte[] buf = new byte[8 * 1024];
        int b;
        while ((b = in.read(buf, 0, buf.length)) != -1) {
            out.write(buf, 0, b);
            out.flush();
        }
        in.close();
        out.close();
    }
}
