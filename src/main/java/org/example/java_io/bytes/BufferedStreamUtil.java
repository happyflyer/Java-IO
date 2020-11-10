package org.example.java_io.bytes;

import java.io.*;

/**
 * 4. 字节流的使用
 * BufferedInputStream
 * BufferedOutputStream
 *
 * @author lifei
 */
public class BufferedStreamUtil {
    /**
     * 带缓冲（字节批量读取）拷贝文件
     *
     * @param srcFile 源文件
     * @param desFile 目的地文件
     * @throws IOException IO异常
     */
    static void copyFileByBuffer(File srcFile, File desFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("srcFile: " + srcFile + "文件不存在！");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException("srcFile: " + srcFile + "不是文件！");
        }
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desFile));
        int c;
        while ((c = bis.read()) != -1) {
            bos.write(c);
            bos.flush();
        }
        bis.close();
        bos.close();
    }

    /**
     * 单字节不带缓冲拷贝文件
     *
     * @param srcFile 源文件
     * @param desFile 目的地文件
     * @throws IOException IO异常
     */
    static void copyFileByByte(File srcFile, File desFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("srcFile: " + srcFile + "文件不存在！");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException("srcFile: " + srcFile + "不是文件！");
        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(desFile);
        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
            out.flush();
        }
        in.close();
        out.close();
    }
}
