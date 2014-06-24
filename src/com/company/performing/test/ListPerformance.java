package com.company.performing.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Write class comments here
 * <p/>
 * Author:sys53
 * DATE 14-6-11 上午11:03
 * version $Id:ListPerformance.java,v 0.1.Exp $
 */
public class ListPerformance {
    static Random rand = new Random();
    static int reps = 1000;
    static List<Test<List<Integer>>> tests = new ArrayList<Test<List<Integer>>>();
    static List<Test<LinkedList<Integer>>> qTests = new ArrayList<Test<LinkedList<Integer>>>();
    static {
        tests.add(new Test<List<Integer>>("add") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i =0; i<loops;i++){
                    container.clear();
                    for (int j=0;j<size;j++){
                        container.add(j);
                    }
                }
                return loops * size;
            }
        });

        tests.add(new Test<List<Integer>>("get") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops = tp.loops * reps;
                int size = container.size();
                for (int i=0; i<loops;i++){
                    container.get(rand.nextInt(size));
                }
                return loops;

            }
        });

        tests.add(new Test<List<Integer>>("set") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops = tp.loops * reps;
                int size = container.size();
                for (int i=0;i<loops;i++){
                    container.set(rand.nextInt(size),47);
                }
                return loops;
            }
        });

        tests.add(new Test<List<Integer>>("iteradd") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                return 0;
            }
        });
    }
}
