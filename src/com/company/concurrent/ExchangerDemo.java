package com.company.concurrent;

import com.company.BasicGenerator;

import java.util.List;
import java.util.concurrent.*;

/**
 * Write class comments here
 * <p/>
 * Author:sys53
 * DATE 14-6-23 上午9:23
 * version $Id:ExchangerDemo.java,v 0.1.Exp $
 */
public class ExchangerDemo {
    static int size = 10;
    static int delay = 5; // Seconds
    public static void main(String[] args) throws Exception {
        if(args.length > 0)
            size = new Integer(args[0]);
        if(args.length > 1)
            delay = new Integer(args[1]);
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<Fat>> xc = new Exchanger<List<Fat>>();
        List<Fat>
                producerList = new CopyOnWriteArrayList<Fat>(),
                consumerList = new CopyOnWriteArrayList<Fat>();
        exec.execute(new ExchangerProducer<Fat>(xc,
                BasicGenerator.create(Fat.class), producerList));
        exec.execute(
                new ExchangerConsumer<Fat>(xc,consumerList));
        TimeUnit.SECONDS.sleep(delay);
        exec.shutdownNow();
    }
} /* Output: (Sample)
Final value: Fat id: 29999
*///:~
