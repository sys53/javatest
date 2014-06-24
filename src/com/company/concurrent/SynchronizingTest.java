package com.company.concurrent;

/**
 * Write class comments here
 * <p/>
 * Author:sys53
 * DATE 14-6-23 下午4:59
 * version $Id:SynchronizingTest.java,v 0.1.Exp $
 */
class SynchronizingTest extends Incrementable {
    public synchronized void increment() { ++counter; }
}
