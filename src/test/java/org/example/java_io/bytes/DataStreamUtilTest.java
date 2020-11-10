package org.example.java_io.bytes;

import org.junit.Test;

import java.io.IOException;

public class DataStreamUtilTest {
    @Test
    public void DataOutputStreamTest() throws IOException {
        DataStreamUtil.writeData("src/test/resources/bytes/test4.txt");
        FileStreamUtil.printHexByByteArray("src/test/resources/bytes/test4.txt");
    }

    @Test
    public void DataInputStreamTest() throws IOException {
        DataStreamUtil.readData("src/test/resources/bytes/test4.txt");
    }
}
