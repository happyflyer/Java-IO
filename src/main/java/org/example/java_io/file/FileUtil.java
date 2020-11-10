package org.example.java_io.file;

import java.io.File;

/**
 * 列出 File 类的一些常用操作，过滤、遍历等
 *
 * @author lifei
 */
class FileUtil {
    /**
     * 列出指定目录下（包括其子目录）的所有文件
     *
     * @param dir 目录名
     */
    static void listDirectory(File dir) {
        if (!dir.exists()) {
            throw new IllegalArgumentException("目录" + dir + "不存在！");
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + "不是目录！");
        }
        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println(file.getAbsolutePath());
                    listDirectory(file);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}
