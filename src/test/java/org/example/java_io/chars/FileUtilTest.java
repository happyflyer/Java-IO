package org.example.java_io.chars;

import org.junit.Test;

import java.io.IOException;

public class FileUtilTest {
    @Test
    public void fileReaderAndWriterTest() throws IOException {
        FileUtil.fileReaderAndWriter("src/test/resources/chars/test.txt", "src/test/resources/chars/test_file.txt");
    }
}
