package org.example.java_io.chars;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 5. 字符流的使用
 * FileReader
 * FileWriter
 *
 * @author lifei
 */
public class FileUtil {
    static void fileReaderAndWriter(String srcFile, String desFile) throws IOException {
        // FileReader 不能自定义读取文件时的编码，默认为项目编码
        // 如果要自定义读取文件时的编码，就需要使用 InputStreamReader
        FileReader fr = new FileReader(srcFile);
        FileWriter fw = new FileWriter(desFile, true);
        char[] buf = new char[2 * 1024];
        int c;
        while ((c = fr.read(buf, 0, buf.length)) != -1) {
            fw.write(buf, 0, c);
            fw.flush();
        }
        fr.close();
        fw.close();
    }
}
