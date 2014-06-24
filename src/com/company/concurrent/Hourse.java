package com.company.concurrent;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Write class comments here
 * <p/>
 * Author:sys53
 * DATE 14-6-19 下午3:51
 * version $Id:Hourse.java,v 0.1.Exp $
 */
public class Hourse implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private int strides = 0;
    private static Random rand = new Random(47);
    private static CyclicBarrier barrier;

    public Hourse(CyclicBarrier b){
        this.barrier = b;
    }
    public synchronized int getStrides(){
        return strides;
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
        try{
            while (!Thread.interrupted()){
                synchronized (this){
                    strides += rand.nextInt(3);
                }
                barrier.await();
            }
        }catch (InterruptedException e){

        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String toString() {
        return "Horse{" +
                "id=" + id +
                '}';
    }

    public String tracks(){
        StringBuffer s= new StringBuffer();
        for(int i=0;i<getStrides();i++){
            s.append("*");
        }
        s.append(id);
        return s.toString();
    }
}
