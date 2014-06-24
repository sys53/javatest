package com.company.concurrent;

import com.company.Generator;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Write class comments here
 * <p/>
 * Author:sys53
 * DATE 14-6-23 上午9:22
 * version $Id:ExchangerProducer.java,v 0.1.Exp $
 */
class ExchangerProducer<T> implements Runnable {
    private Generator<T> generator;
    private Exchanger<List<T>> exchanger;
    private List<T> holder;

    ExchangerProducer(Exchanger<List<T>> exchg,
                      Generator<T> gen, List<T> holder) {
        exchanger = exchg;
        generator = gen;
        this.holder = holder;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (int i = 0; i < ExchangerDemo.size; i++)
                    holder.add(generator.next());
                // Exchange full for empty:
                holder = exchanger.exchange(holder);
            }
        } catch (InterruptedException e) {
            // OK to terminate this way.
        }
    }
}
