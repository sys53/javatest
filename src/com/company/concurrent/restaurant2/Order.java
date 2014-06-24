package com.company.concurrent.restaurant2;

/**
 * Write class comments here
 * <p/>
 * Author:sys53
 * DATE 14-6-23 上午10:42
 * version $Id:Order.java,v 0.1.Exp $
 */
class Order { // (A data-transfer object)
    private static int counter = 0;
    private final int id = counter++;
    private final Customer customer;
    private final WaitPerson waitPerson;
    private final Food food;
    public Order(Customer cust, WaitPerson wp, Food f) {
        customer = cust;
        waitPerson = wp;
        food = f;
    }
    public Food item() { return food; }
    public Customer getCustomer() { return customer; }
    public WaitPerson getWaitPerson() { return waitPerson; }
    public String toString() {
        return "Order: " + id + " item: " + food +
                " for: " + customer +
                " served by: " + waitPerson;
    }
}
