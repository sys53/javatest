package com.company;

/**
 * Created by qujunnan on 14-5-20.
 */
public class OverloadingVarargs {
    static void f(short i ,Character ... args){
        System.out.println("first");
    }

    static void f(Character ... args){
        System.out.println("second");
    }

    static void f(Integer ... args){
        System.out.println("third");
    }
    static void f(Character i,Integer ... args){
        System.out.println("forth");
    }

    public static void main(String[] args){
        f((short)1,'a');
        f('a','b');
        f(1,2);
        f('c',2,3);
    }
}
