package com.company.reference;

import java.lang.ref.*;
import java.util.LinkedList;

/**
 * Write class comments here
 * <p/>
 * Author:sys53
 * DATE 14-6-11 下午3:27
 * version $Id:References.java,v 0.1.Exp $
 */
public class References {
    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<VeryBig>();
    public static void checkQueue(){
        Reference<? extends VeryBig> inq = rq.poll();
        if(inq!=null){
            System.out.println(" In queue: "+inq.get());
        }
    }

    public static void main(String[] args){
        int size = 10;
        LinkedList<SoftReference<VeryBig>> sa = new LinkedList<SoftReference<VeryBig>>();
        for(int i=0;i<size; i++){
           sa.add(new SoftReference<VeryBig>(new VeryBig("Soft" + i),rq));
            System.out.println("Just created : "+ sa.getLast());
            checkQueue();
        }

        LinkedList<WeakReference<VeryBig>> wa = new LinkedList<WeakReference<VeryBig>>();
        for(int i=0;i<size;i++){
            wa.add(new WeakReference<VeryBig>(new VeryBig("Weak"+i),rq));
            System.out.println("Just created : "+ wa.getLast());
            checkQueue();
        }

        SoftReference<VeryBig> s = new SoftReference<VeryBig>(new VeryBig("Soft"));

        WeakReference<VeryBig> w = new WeakReference<VeryBig>(new VeryBig("Weak"));
        System.gc();

        LinkedList<PhantomReference<VeryBig>> pa = new LinkedList<PhantomReference<VeryBig>>();
        for(int i=0;i<size;i++){
            pa.add(new PhantomReference<VeryBig>(new VeryBig("Phantom "+ i),rq));
            System.out.println("Just created:"+pa.getLast());
            checkQueue();
        }
    }
}
