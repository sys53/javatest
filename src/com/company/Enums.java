package com.company;

import java.util.Random;

/**
 * Write class comments here
 * <p/>
 * Author:sys53
 * DATE 14-6-23 上午10:59
 * version $Id:Enums.java,v 0.1.Exp $
 */
public class Enums {
    private static Random rand = new Random(47);
    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }
    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }
}
