package ch12.sec05;

import java.util.Arrays;

public class BytesToStringExample {
    public static void main(String[] args) throws Exception {
        String data = "자바";

        // String -> byte 배열(UTF-8 인코딩)
        byte[] arr1 = data.getBytes();
        // byte[] arr1 = data.getBytes()
        System.out.println("arr1: " + Arrays.toString(arr1));

        String str1 = new String(arr1);
        System.out.println("str1L " + str1);
    }
}
