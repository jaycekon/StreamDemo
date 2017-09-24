package com.Jaycekon.stream.restructure.Model;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by Jaycekon on 2017/9/24.
 */
public class OnlineBankingLambda {
    public void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
        Customer customer = new Customer(id);
        makeCustomerHappy.accept(customer);
    }


    public void processFunction(int id, Function<Customer, String> makeCustemHappy) {
        Customer customer = new Customer(id);
        String name = makeCustemHappy.apply(customer);
        System.out.println(name);
    }
}
