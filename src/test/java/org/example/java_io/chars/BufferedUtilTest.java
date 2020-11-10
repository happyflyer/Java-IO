package org.example.java_io.chars;

import org.junit.Test;

import java.io.IOException;

public class BufferedUtilTest {
    @Test
    public void bufferedReaderAndWriterTest() throws IOException {
        BufferedUtil.bufferedReaderAndWriter("src/test/resources/chars/test.txt", "src/test/resources/chars/test_buffer1.txt");
    }

    @Test
    public void bufferedReaderAndWriter2Test() throws IOException {
        BufferedUtil.bufferedReaderAndWriter2("src/test/resources/chars/test.txt", "src/test/resources/chars/test_buffer2.txt");
    }
}
