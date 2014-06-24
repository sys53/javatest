package com.company.concurrent.restaurant2;

import java.util.concurrent.SynchronousQueue;

/**
 * Write class comments here
 * <p/>
 * Author:sys53
 * DATE 14-6-23 上午10:45
 * version $Id:Customer.java,v 0.1.Exp $
 */
class Customer implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final WaitPerson waitPerson;
    // Only one course at a time can be received:
    private SynchronousQueue<Plate> placeSetting =
            new SynchronousQueue<Plate>();
    public Customer(WaitPerson w) { waitPerson = w; }
    public void
    deliver(Plate p) throws InterruptedException {
        // Only blocks if customer is still
        // eating the previous course:
        placeSetting.put(p);
    }
    public void run() {
        for(Course course : Course.values()) {
            Food food = course.randomSelection();
            try {
                waitPerson.placeOrder(this, food);
                // Blocks until course has been delivered:
                System.out.println(this + "eating " + placeSetting.take());
            } catch(InterruptedException e) {
                System.out.println(this + "waiting for " +
                        course + " interrupted");
                break;
            }
        }
        System.out.println(this + "finished meal, leaving");
    }
    public String toString() {
        return "Customer " + id + " ";
    }
}
