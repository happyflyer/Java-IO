package org.example.java_io.serial;

import org.junit.Test;

import java.io.IOException;

public class ObjectSerialDemoTest {
    @Test
    public void saveObjectTest() throws IOException {
        ObjectSerialDemo.saveObject("src/test/resources/serial/stu1.txt");
    }

    @Test
    public void readObjectTest() throws IOException, ClassNotFoundException {
        ObjectSerialDemo.readObject("src/test/resources/serial/stu1.txt");
    }
}
