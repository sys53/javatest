package com.company;

import com.company.son.SuperFather;

/**
 * Created by qujunnan on 14-5-20.
 */
public class Father extends SuperFather {

    public Father(){
        draw();
    }
    public void draw(){
        System.out.println("draw Father");
    }
    public int a =1;
    public static void sayHello(){
        System.out.println("hello world!");
    }

    private void sayFuck(){

    }

    private final void say(){

    }
    private void fuckMe(Father father){
     System.out.println("fuck me");
    }

    public void test(){
        Father other = new Father();
        this.fuckMe(other);
        other.fuckMe(this);
    }

}
