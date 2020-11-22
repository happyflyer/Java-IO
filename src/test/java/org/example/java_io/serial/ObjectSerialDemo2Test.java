package org.example.java_io.serial;

import org.junit.Test;

import java.io.IOException;

public class ObjectSerialDemo2Test {
    @Test
    public void saveFooTest() throws IOException {
        ObjectSerialDemo2.saveFoo("src/test/resources/serial/foo.txt");
    }

    @Test
    public void readFooTest() throws IOException, ClassNotFoundException {
        ObjectSerialDemo2.readFoo("src/test/resources/serial/foo.txt");
    }

    @Test
    public void saveBarTest() throws IOException {
        ObjectSerialDemo2.saveBar("src/test/resources/serial/bar.txt");
    }

    @Test
    public void readBarTest() throws IOException, ClassNotFoundException {
        ObjectSerialDemo2.readBar("src/test/resources/serial/bar.txt");
    }
}
