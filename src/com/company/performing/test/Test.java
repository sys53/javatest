package com.company.performing.test;

/**
 * Write class comments here
 * <p/>
 * Author:sys53
 * DATE 14-6-11 上午10:15
 * version $Id:Test.java,v 0.1.Exp $
 */
public abstract class Test<C> {

    String name;
    public Test(String name){
        this.name = name;
    }

    abstract int test(C container,TestParam tp);
}
