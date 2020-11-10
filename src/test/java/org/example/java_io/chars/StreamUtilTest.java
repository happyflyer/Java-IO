package org.example.java_io.chars;

import org.junit.Test;

import java.io.IOException;

public class StreamUtilTest {
    @Test
    public void readerTest() throws IOException {
        StreamUtil.reader("src/test/resources/chars/test.txt");
    }

    @Test
    public void WriterTest() throws IOException {
        StreamUtil.writer("src/test/resources/chars/test.txt", "src/test/resources/chars/test_gbk.txt");
    }
}
