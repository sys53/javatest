package com.company.inner;

/**
 * Created by qujunnan on 14-5-23.
 */
public class InheritInner extends WithInner.Inner{

    InheritInner(WithInner withInner){
        withInner.super();
    }

    @Override
    protected void print() {
        super.print();
        System.out.println(". Now i am InheritInner");
    }

    public static void main(String[] args){
        WithInner wi = new WithInner();
        InheritInner inheritInner = new InheritInner(wi);
        inheritInner.print();

    }
}
