package com.company.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Write class comments here
 * <p/>
 * Author:sys53
 * DATE 14-6-19 下午4:50
 * version $Id:HorseRace.java,v 0.1.Exp $
 */
public class HorseRace {
    static final int FINISH_LINE = 75;
    private List<Hourse> horses = new ArrayList<Hourse>();
    private ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;

    public HorseRace(int nHorses, final int pause) {
        barrier = new CyclicBarrier(nHorses, new Runnable() {
            @Override
            public void run() {
                StringBuffer s = new StringBuffer();
                for (int i = 0; i < FINISH_LINE; i++) {
                    s.append("=");
                }
                System.out.println(s);
                for (Hourse hourse : horses) {
                    System.out.println(hourse.tracks());
                }
                for (Hourse hourse : horses) {
                    if (hourse.getStrides() >= FINISH_LINE) {
                        System.out.println(hourse + "won!");
                        exec.shutdownNow();
                        return;
                    }
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(pause);
                } catch (InterruptedException e) {
                    System.out.println("barries -action sleep interrupted.");
                }
            }
        });
        for (int i = 0; i < nHorses; i++) {
            Hourse hourse = new Hourse(barrier);
            horses.add(hourse);
            exec.execute(hourse);
        }
    }

    public static void main(String[] args) {
        int nHorses = 7;
        int pause = 200;
        if (args.length > 0) {
            int n = Integer.parseInt(args[0]);
            nHorses = n > 0 ? n : nHorses;
        }
        if (args.length > 1) {
            int p = Integer.parseInt(args[1]);
            pause = p > -1 ? p : pause;
        }
        new HorseRace(nHorses,pause);
    }
}
