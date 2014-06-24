package com.company;

import com.company.son.Son;
import com.company.son.SuperFather;

public class Main {

    public static void main(String[] args) {
//        byte b = (byte)0xff;
//        System.out.printf("%d=0x%02x\n", b, b);
//        byte d = 0;
//        System.out.printf("%d=0x%02x\n", d|1, d|1);
//        System.out.println(Integer.toBinaryString(d));
//        char c = (char)(b & 0x00ff);
//        System.out.printf("%d=0x%02x\n", (int)c, (int)c);
//        short s = (short)(b & 0x00ff);
//        System.out.printf("%d=0x%02x\n", s, s);
//        int i = b & 0x00ff;
//        System.out.printf("%d=0x%02x\n", i, i);

        // prefix three bits
        byte VARINT = 0, OBJECT = (byte)0x80;

        // varint tag
        byte VARINT8 = VARINT;
//        byte VARINT16 = VARINT | 1;
//        VARINT24 = VARINT | 2, VARINT32 = VARINT | 3;

//        byte VARINT40 = VARINT | 4, VARINT48 = VARINT | 5, VARINT56 = VARINT | 6, VARINT64 = VARINT | 7;
        System.out.println(Integer.toBinaryString(OBJECT));
        System.out.println(Integer.toBinaryString(VARINT|1));
        System.out.println(Integer.toBinaryString(VARINT|2));
        System.out.println(Integer.toBinaryString(VARINT|3));
        System.out.println(Integer.toBinaryString(VARINT|4));
        System.out.println(Integer.toBinaryString(VARINT|5));
        System.out.println(Integer.toBinaryString(VARINT|6));
        System.out.println(Integer.toBinaryString(VARINT|7));


        System.out.println(Integer.toBinaryString(VARINT|10));
        System.out.println(Integer.toBinaryString(VARINT|11));
        System.out.println(Integer.toBinaryString(VARINT|12));
        System.out.println(Integer.toBinaryString(VARINT|13));
        System.out.println(Integer.toBinaryString(0xE0));
        System.out.println(Integer.toBinaryString(0xC0));
        System.out.println(Integer.toBinaryString(0x1F));
        System.out.println(Integer.toBinaryString(0x3F));
        System.out.println(Integer.toBinaryString(0x0F));
        System.out.println(Integer.toBinaryString(0xe0));

        System.out.println(+ 0.001);


//        TestObject testObject = new TestObject();
//        testObject.sayHello();
        SuperFather.sayHello();

        Father father = new Son();
//        System.out.println(father.a);
//        Son son = new Son();
//        System.out.println(son.a);
    }
}
