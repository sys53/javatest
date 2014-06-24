package com.company.functional;

/**
 * Write class comments here
 * <p/>
 * Author:sys53
 * DATE 14-6-9 下午3:35
 * version $Id:Collector.java,v 0.1.Exp $
 */
public interface Collector<T> extends UnaryFunction<T,T> {
    T result();
}
