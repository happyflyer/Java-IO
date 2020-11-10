package org.example.java_io.chars;

import java.io.*;

/**
 * 5. 字符流的使用
 * InputStreamReader
 * OutputStreamWriter
 *
 * @author lifei
 */
public class StreamUtil {
    /**
     * 按字符读文件，带缓冲
     *
     * @param fileName 读取文件
     * @throws IOException IO异常
     */
    static void reader(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        // 这里第二个参数是解析字节序列的编码，默认为项目的编码
        InputStreamReader isr = new InputStreamReader(in);
        // 8k
        char[] buf = new char[8 * 1024];
        int c;
        while ((c = isr.read(buf, 0, buf.length)) != -1) {
            String s = new String(buf, 0, c);
            System.out.print(s);
        }
        isr.close();
    }

    /**
     * 这实际上也是一个实现了拷贝文件的方法
     * 拷贝的单位为字符
     * 项目编码为 utf-8
     * 这里特地转码存储为 gbk
     *
     * @param srcFile 源文件
     * @param desFile 目的地文件
     * @throws IOException IIO异常
     */
    static void writer(String srcFile, String desFile) throws IOException {
        FileInputStream in = new FileInputStream(srcFile);
        InputStreamReader isr = new InputStreamReader(in);
        FileOutputStream out = new FileOutputStream(desFile);
        OutputStreamWriter osw = new OutputStreamWriter(out, "gbk");
        // 8k
        char[] buf = new char[8 * 1024];
        int c;
        while ((c = isr.read(buf, 0, buf.length)) != -1) {
            String s = new String(buf, 0, c);
            osw.write(buf, 0, c);
            osw.flush();
        }
        isr.close();
        osw.close();
    }
}
