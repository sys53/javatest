package com.company.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Write class comments here
 * <p/>
 * Author:sys53
 * DATE 14-6-19 下午2:38
 * version $Id:WaitingTask.java,v 0.1.Exp $
 */
public class WaitingTask implements Runnable {
    private static int counter = 0;
    private final int id = counter++;

    private final CountDownLatch latch;

    WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p/>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            latch.await();
            System.out.println("Latch barrier passed for " + this);
        } catch (InterruptedException e) {
            System.out.println(this + "interrupted");

        }
    }

    @Override
    public String toString() {
        return String.format("WaitingTask %1$-3d", id);
    }
}
