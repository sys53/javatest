package com.company.generic;

/**
 * Write class comments here
 * <p/>
 * Author:sys53
 * DATE 14-6-5 下午6:47
 * version $Id:SelfBounded.java,v 0.1.Exp $
 */
public class SelfBounded<T extends SelfBounded<T>> {
    protected void print(){
        System.out.println(getClass().getSimpleName());
    }
    public static void main(String[] args){
        SelfBounded<SubSelfBounded> selfBounded = new SubSelfBounded();
        selfBounded.print();
    }

}