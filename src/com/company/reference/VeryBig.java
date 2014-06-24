package com.company.reference;

/**
 * Write class comments here
 * <p/>
 * Author:sys53
 * DATE 14-6-11 下午3:24
 * version $Id:VeryBig.java,v 0.1.Exp $
 */
public class VeryBig {
    private static final int SIZE = 10000;
    private long[] la = new long[SIZE];
    private String ident;

    public VeryBig(String id) {
        ident = id;
    }

    public String toString() {
        return ident;
    }

    protected void finalize() {
        System.out.println("Finalize " + ident);
    }


}
