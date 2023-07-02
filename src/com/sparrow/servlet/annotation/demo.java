package com.sparrow.servlet.annotation;

/**
 * @Author: 诉衷情の麻雀
 * @Description: TODO
 * @DateTime: 2023/6/23 10:54
 **/
public class demo {
    public static void main(String[] args) {
        Integer a = Integer.valueOf(100);
        Integer b = 100;
        System.out.println(a == b);

        Integer c = Integer.valueOf(1000);
        Integer d = 1000;

        System.out.println(c == d);
        int e = 1000;
        int f = 1000;

        System.out.println(e == f);
    }
}
