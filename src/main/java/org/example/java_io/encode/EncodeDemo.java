package org.example.java_io.encode;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * 1. 编码问题
 *
 * @author lifei
 */
public class EncodeDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "慕课ABC";

        // 使用项目默认的编码
        byte[] bytes1 = s.getBytes();
        for (byte b : bytes1) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();

        byte[] bytes2 = s.getBytes("GBK");
        for (byte b : bytes2) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();

        byte[] bytes3 = s.getBytes(StandardCharsets.UTF_8);
        for (byte b : bytes3) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();

        byte[] bytes4 = s.getBytes(StandardCharsets.UTF_16BE);
        for (byte b : bytes4) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();

        String str1 = new String(bytes4);
        System.out.println(str1);

        String str2 = new String(bytes4, StandardCharsets.UTF_16BE);
        System.out.println(str2);
    }
}
