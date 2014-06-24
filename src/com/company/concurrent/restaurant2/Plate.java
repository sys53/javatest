package com.company.concurrent.restaurant2;

/**
 * Write class comments here
 * <p/>
 * Author:sys53
 * DATE 14-6-23 上午10:44
 * version $Id:Plate.java,v 0.1.Exp $
 */
class Plate {
    private final Order order;
    private final Food food;
    public Plate(Order ord, Food f) {
        order = ord;
        food = f;
    }
    public Order getOrder() { return order; }
    public Food getFood() { return food; }
    public String toString() { return food.toString(); }
}
