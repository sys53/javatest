package com.company.exception;


/**
 * Created by qujunnan on 14-5-25.
 */
abstract class Inning {
    public Inning() throws BaseballException {

    }

    public void event() throws BaseballException {

    }

    public abstract void atBat() throws Strike, Foul;

    public void walk() {
    }
}
