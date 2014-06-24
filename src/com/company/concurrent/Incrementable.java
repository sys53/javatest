package com.company.concurrent;

/**
 * Write class comments here
 * <p/>
 * Author:sys53
 * DATE 14-6-23 下午4:59
 * version $Id:Incrementable.java,v 0.1.Exp $
 */
abstract class Incrementable {
    protected long counter = 0;
    public abstract void increment();
}
