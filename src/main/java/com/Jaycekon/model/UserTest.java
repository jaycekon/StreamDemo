package com.Jaycekon.model;

import org.junit.Test;

/**
 * Created by Jaycekon on 2017/9/5.
 */
public class UserTest {


    @Test
    public void test(){
        User user = new User("Jaycekon","man","18814127384");
        System.out.println(user.toString());
        user.setName("beidan")
                .setSex("women")
                .setPhone("18814127307");

        System.out.println(user.toString());
    }
}
