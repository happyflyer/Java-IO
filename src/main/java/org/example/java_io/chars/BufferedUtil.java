package org.example.java_io.chars;

import java.io.*;

/**
 * 5. 字符流的使用
 * BufferedReader
 * BufferedWriter
 *
 * @author lifei
 */
public class BufferedUtil {
    static void bufferedReaderAndWriter(String srcFile, String desFile) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(srcFile)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(desFile)));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        br.close();
        bw.close();
    }

    static void bufferedReaderAndWriter2(String srcFile, String desFile) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(srcFile)));
        // PrintWriter pw = new PrintWriter(new FileOutputStream(desFile));
        PrintWriter pw = new PrintWriter(new FileOutputStream(desFile), true);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            pw.println(line);
        }
        br.close();
        pw.close();
    }
}
