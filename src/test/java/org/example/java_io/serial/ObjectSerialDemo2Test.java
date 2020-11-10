package org.example.java_io.serial;

import org.junit.Test;

import java.io.IOException;

public class ObjectSerialDemo2Test {
    @Test
    public void saveObjectTest() throws IOException {
        // ObjectSerialDemo2.saveObject("src/test/resources/serial/foo.txt");
        ObjectSerialDemo2.saveObject("src/test/resources/serial/bar.txt");
    }

    @Test
    public void readObjectTest() throws IOException, ClassNotFoundException {
        // ObjectSerialDemo2.readObject("src/test/resources/serial/foo.txt");
        ObjectSerialDemo2.readObject("src/test/resources/serial/bar.txt");
    }
}
