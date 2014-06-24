package com.company;

import com.company.son.SuperFather;

/**
 * Created by qujunnan on 14-5-20.
 */
public class TestObject extends SuperFather{
    static{
        testPrint = new TestPrint(1);
    }
    {
        testPrint = new TestPrint(2);
    }
    private static TestPrint testPrint = new TestPrint(3);
    private TestPrint instance = new TestPrint(4);

    private static final int a =0;
    static{
        testPrint = new TestPrint(5);
    }
    {
        testPrint = new TestPrint(6);
    }

    public TestObject(){
        testPrint = new TestPrint(7);
    }
    private static void print(){
        System.out.println("hh");
    }

    public static void main(String[] args){
//        TestObject testObject = new TestObject();
//        testObject.sayHello();
        SuperFather.sayHello();
    }


}
