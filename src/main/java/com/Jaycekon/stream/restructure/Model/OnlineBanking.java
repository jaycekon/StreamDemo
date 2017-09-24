package com.Jaycekon.stream.restructure.Model;

/**
 * Created by Jaycekon on 2017/9/24.
 */
public abstract class OnlineBanking {
    public void processCustomer(int id) {
        Customer customer = new Customer(id);
        makeCustomerHappy(customer);
    }

    abstract void makeCustomerHappy(Customer customer);
}
