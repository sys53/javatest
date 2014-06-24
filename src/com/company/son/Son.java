package com.company.son;

import com.company.Father;

/**
 * Created by qujunnan on 14-5-20.
 */
public class Son extends Father {

    private int b = 10;


    public Son(){
        draw();
    }


    @Override
    public void draw() {
        System.out.println("draw son "+b);
    }

    public int a = 2;
    protected void sayHello1() {
        sayHello();
    }

    public void sayDie(){
        sayHello();
    }
}
