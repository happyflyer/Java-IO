package org.example.java_io.bytes;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class BufferedStreamUtilTest {
    @Test
    public void copyFileByBufferTest() throws IOException {
        File srcFile = new File("src/test/resources/bytes/test.txt");
        File desFile = new File("src/test/resources/bytes/test5.txt");
        BufferedStreamUtil.copyFileByBuffer(srcFile, desFile);
    }

    @Test
    public void compareByteAndBufferTest() throws IOException {
        File srcFile = new File("src/test/resources/bytes/wallpaper.jpg");
        File desFile1 = new File("src/test/resources/bytes/wallpaper1.jpg");
        File desFile2 = new File("src/test/resources/bytes/wallpaper2.jpg");
        File desFile3 = new File("src/test/resources/bytes/wallpaper3.jpg");

        long start1 = System.currentTimeMillis();
        BufferedStreamUtil.copyFileByByte(srcFile, desFile1);
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        BufferedStreamUtil.copyFileByBuffer(srcFile, desFile2);
        long end2 = System.currentTimeMillis();

        long start3 = System.currentTimeMillis();
        FileStreamUtil.copyFile(srcFile, desFile3);
        long end3 = System.currentTimeMillis();

        System.out.println("Byte: " + (end1 - start1));
        System.out.println("Buffered: " + (end2 - start2));
        System.out.println("8k buffer: " + (end3 - start3));
    }
}
