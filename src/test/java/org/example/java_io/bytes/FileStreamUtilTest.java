package org.example.java_io.bytes;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileStreamUtilTest {
    @Test
    public void printHexTest() throws IOException {
        FileStreamUtil.printHex("src/test/resources/bytes/test.txt");
    }

    @Test
    public void printHexByByteArrayTest() throws IOException {
        FileStreamUtil.printHexByByteArray("src/test/resources/bytes/test.txt");
    }

    @Test
    public void writeByteTest() throws IOException {
        FileStreamUtil.writeByte("src/test/resources/bytes/test2.txt");
        FileStreamUtil.printHexByByteArray("src/test/resources/bytes/test2.txt");
    }

    @Test
    public void copyFileTest() throws IOException {
        File srcFile = new File("src/test/resources/bytes/test.txt");
        File desFile = new File("src/test/resources/bytes/test3.txt");
        FileStreamUtil.copyFile(srcFile, desFile);
    }
}
