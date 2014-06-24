package com.company.performing.test;

import java.util.List;

/**
 * Write class comments here
 * <p/>
 * Author:sys53
 * DATE 14-6-11 上午10:32
 * version $Id:Tester.java,v 0.1.Exp $
 */
public class Tester<C> {
    public static int fieldWidth = 8;
    public static TestParam[] defaultParams = TestParam.array(10,5000,100,5000,1000,5000,10000,500);
    protected C initialize(int size){
        return container;
    }
    protected C container;

    private String headline = "";

    private List<Test<C>> tests;

    private static String stringField(){
        return "%" + fieldWidth + "s";
    }

    private static String numberField(){
        return "%" + fieldWidth + "d";
    }
    private static int sizeWidth = 5;

    private static String sizeField = "%" + sizeWidth + "s";

    private TestParam[] params = defaultParams;

    public Tester(C container,List<Test<C>> tests){
        this.container = container;
        this.tests = tests;
        if(container!=null){
            headline = container.getClass().getSimpleName();
        }
    }

    public Tester(C container,List<Test<C>> tests,TestParam[] params){
        this(container,tests);
        this.params = params;
    }

    public void setHeadline(String newHeadline){
        this.headline = newHeadline;
    }

    public static <C> void run(C cntnr,List<Test<C>> tests){
        new Tester<C>(cntnr,tests).timedTest();
    }

    public static <C> void run(C cntnr,List<Test<C>> tests,TestParam[] params ){
        new Tester<C>(cntnr,tests,params).timedTest();
    }

    private void timedTest() {
        displayHeader();
        for (TestParam param : params){
            System.out.format(sizeField,param.size);
            for (Test<C> test : tests){
                C c = initialize(param.size);
                long start = System.nanoTime();
                int reps = test.test(c,param);
                long duration = System.nanoTime();
                long timePerRep = duration/reps;
                System.out.format(numberField(),timePerRep);
            }
            System.out.println();
        }

    }

    private void displayHeader() {
        int width = fieldWidth * tests.size() +sizeWidth;
        int dashLength = width - headline.length() - 1;

        StringBuffer head = new StringBuffer(width);
        for(int i=0; i<dashLength/2;i++){
            head.append('-');
        }
        head.append(' ');
        head.append(headline);
        head.append(' ');
        for(int i=0; i<dashLength/2;i++){
            head.append('-');
        }
        System.out.print(head);

        System.out.format(sizeField,"size");

        for(Test test : tests){
            System.out.format(stringField(),test.name);
        }
        System.out.println();


    }
}
