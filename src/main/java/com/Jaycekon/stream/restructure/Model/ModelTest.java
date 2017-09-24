package com.Jaycekon.stream.restructure.Model;

import org.junit.Test;

/**
 * Created by Jaycekon on 2017/9/24.
 */
public class ModelTest {


    @Test
    public void test1() {
        new OnlineBankingLambda().processCustomer(123, (Customer c) -> System.out.println(c.getName()));

        new OnlineBankingLambda().processFunction(123, Customer::getName);
    }
}
