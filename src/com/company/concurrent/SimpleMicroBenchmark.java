package com.company.concurrent;

/**
 * Write class comments here
 * <p/>
 * Author:sys53
 * DATE 14-6-23 下午5:00
 * version $Id:SimpleMicroBenchmark.java,v 0.1.Exp $
 */
public class SimpleMicroBenchmark {
    static long test(Incrementable incr) {
        long start = System.nanoTime();
        for(long i = 0; i < 10000000L; i++)
            incr.increment();
        return System.nanoTime() - start;
    }
    public static void main(String[] args) {
        long synchTime = test(new SynchronizingTest());
        long lockTime = test(new LockingTest());
        System.out.printf("synchronized: %1$10d\n", synchTime);
        System.out.printf("Lock:         %1$10d\n", lockTime);
        System.out.printf("Lock/synchronized = %1$.3f",
                (double)lockTime/(double)synchTime);
    }
}