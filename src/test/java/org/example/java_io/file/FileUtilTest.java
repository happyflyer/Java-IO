package org.example.java_io.file;

import org.junit.Test;

import java.io.File;

public class FileUtilTest {
    @Test
    public void listDirectoryTest() {
        FileUtil.listDirectory(new File("src"));
    }
}
