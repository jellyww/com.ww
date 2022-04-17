package com.ww.string;

public class StringTest {
    public static void main(String[] args) {
        String s1 = new String("1") + new String("2");
        String s3 = new String("12");
        String s2 = s1.intern();
//        String s2 = "12";
        System.out.println(s1 == s2);
        try {
            Thread.sleep(10000000000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
