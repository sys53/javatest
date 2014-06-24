package com.company.exception;

/**
 * Created by qujunnan on 14-5-25.
 */
interface Storm {
    public void event() throws RainedOut;
    public void rainHard() throws RainedOut;
}
