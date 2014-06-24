package com.company.concurrent;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Write class comments here
 * <p/>
 * Author:sys53
 * DATE 14-6-23 上午9:24
 * version $Id:ExchangerConsumer.java,v 0.1.Exp $
 */
class ExchangerConsumer<T> implements Runnable {
    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    private volatile T value;
    ExchangerConsumer(Exchanger<List<T>> ex, List<T> holder){
        exchanger = ex;
        this.holder = holder;
    }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                holder = exchanger.exchange(holder);
                for(T x : holder) {
                    value = x; // Fetch out value
                    holder.remove(x); // OK for CopyOnWriteArrayList
                }
            }
        } catch(InterruptedException e) {
            // OK to terminate this way.
        }
        System.out.println("Final value: " + value);
    }
}
