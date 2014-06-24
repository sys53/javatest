package com.company.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Write class comments here
 * <p/>
 * Author:sys53
 * DATE 14-6-19 下午2:45
 * version $Id:CountDownLatchDemo.java,v 0.1.Exp $
 */
public class CountDownLatchDemo {
    static final int SIZE = 100;
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(SIZE);
        for (int i=0; i<10; i++){
            exec.execute(new WaitingTask(latch));
        }
        for(int i=0;i<SIZE;i++){
            exec.execute(new TaskPortion(latch));
        }
        System.out.println("Launched all tasks");
        exec.shutdown();
    }
}
