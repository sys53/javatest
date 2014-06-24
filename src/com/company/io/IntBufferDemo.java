package com.company.io;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * Write class comments here
 * <p/>
 * Author:sys53
 * DATE 14-6-12 下午1:58
 * version $Id:IntBufferDemo.java,v 0.1.Exp $
 */
public class IntBufferDemo {

    private static final int BSIZE = 1024;

    public static void main(String[] args){
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer ib = bb.asIntBuffer();
        ib.put(new int[]{11,32,37,99,143,811,1016});
        System.out.println(ib.get(3));
        ib.put(3,11811);
        ib.flip();
        while (ib.hasRemaining()){
            int i = ib.get();
            System.out.println(i);
        }
    }

}
