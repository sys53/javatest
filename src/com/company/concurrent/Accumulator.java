package com.company.concurrent;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Write class comments here
 * <p/>
 * Author:sys53
 * DATE 14-6-23 下午5:04
 * version $Id:Accumulator.java,v 0.1.Exp $
 */
abstract class Accumulator {
    public static long cycles = 50000L;
    // Number of Modifiers and Readers during each test:
    private static final int N = 4;
    public static ExecutorService exec =
            Executors.newFixedThreadPool(N * 2);
    private static CyclicBarrier barrier =
            new CyclicBarrier(N * 2 + 1);
    protected volatile int index = 0;
    protected volatile long value = 0;
    protected long duration = 0;
    protected String id = "error";
    protected final static int SIZE = 100000;
    protected static int[] preLoaded = new int[SIZE];

    static {
        // Load the array of random numbers:
        Random rand = new Random(47);
        for (int i = 0; i < SIZE; i++)
            preLoaded[i] = rand.nextInt();
    }

    public abstract void accumulate();

    public abstract long read();

    private class Modifier implements Runnable {
        public void run() {
            for (long i = 0; i < cycles; i++)
                accumulate();
            try {
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class Reader implements Runnable {
        private volatile long value;

        public void run() {
            for (long i = 0; i < cycles; i++)
                value = read();
            try {
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void timedTest() {
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            exec.execute(new Modifier());
            exec.execute(new Reader());
        }
        try {
            barrier.await();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        duration = System.nanoTime() - start;
        System.out.println(String.format("%-13s: %13d\n", id, duration));
    }

    public static void
    report(Accumulator acc1, Accumulator acc2) {
        System.out.println(String.format("%-22s: %.2f\n", acc1.id + "/" + acc2.id,
                (double) acc1.duration / (double) acc2.duration));
    }
}
