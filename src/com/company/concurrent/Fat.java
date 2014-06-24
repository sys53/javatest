package com.company.concurrent;

/**
 * Write class comments here
 * <p/>
 * Author:sys53
 * DATE 14-6-23 上午8:56
 * version $Id:Fat.java,v 0.1.Exp $
 */
public class Fat {
    private volatile double d; // Prevent optimization
    private static int counter = 0;
    private final int id = counter++;
    public Fat() {
        // Expensive, interruptible operation:
        for(int i = 1; i < 10000; i++) {
            d += (Math.PI + Math.E) / (double)i;
        }
    }
    public void operation() { System.out.println(this); }
    public String toString() { return "Fat id: " + id; }
}
