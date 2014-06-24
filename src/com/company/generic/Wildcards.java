package com.company.generic;


/**
 * Write class comments here
 * <p/>
 * Author:sys53
 * DATE 14-6-4 下午3:49
 * version $Id:Wildcards.java,v 0.1.Exp $
 */
public class Wildcards {
    static void rawArgs(Holder holder, Object arg) {
        holder.setValue(arg);
        holder.setValue(new Wildcards());
//        T t = holder.getValue();

        Object obj = holder.getValue();
    }

    static void unboundedArg(Holder<?> holder, Object arg) {
//        holder.setValue(arg);
//        holder.setValue(new Wildcards());
//        T t = holder.getValue();
        Object obj = holder.getValue();
    }

    static <T> T exact1(Holder<T> holder) {
        T t = holder.getValue();
        return t;
    }

    static <T> T exact2(Holder<T> holder, T arg) {
        holder.setValue(arg);
        T t = holder.getValue();
        return t;
    }

    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
//        holder.setValue(arg);
        T t = holder.getValue();
        return t;
    }

    static <T> void wildSupertype(Holder<? super T> holder, T arg) {
        holder.setValue(arg);
//        T t = holder.getValue();
        Object obj = holder.getValue();
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Long>();
        raw = new Holder();
        Holder<Long> qualified = new Holder<Long>();
        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bouned = new Holder<Long>();
        Long lng = 1L;
        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bouned, lng);

        unboundedArg(raw, lng);
        unboundedArg(qualified, lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bouned, lng);

        Object r1 = exact1(raw);

        Long r2 = exact1(qualified);

        Object r3 = exact1(unbounded);
        Long r4 = exact1(bouned);

        Long r5 = (Long) exact2(raw, lng);

        Long r6 = exact2(qualified, lng);

//        Long r7 = exact2(unbounded,lng);

//        Long r8 = exact2(bouned,lng);

        Long r9 = (Long) wildSubtype(raw, lng);
        Long r10 = wildSubtype(qualified, lng);
//         Object r11 = wildSubtype(unbounded, lng);
        Long r12 = wildSubtype(bouned, lng);

        wildSupertype(raw, lng);
        wildSupertype(qualified, lng);
//        wildSupertype(unbounded,lng);
//        wildSupertype(bouned,lng);
    }
}
