package com.Jaycekon.stream.restructure.Validation;

import org.junit.Test;

/**
 * Created by Jaycekon on 2017/9/24.
 */
public class ValidatorTest {

    @Test
    public void test() {
        Validator validator = new Validator(new IsAllLowerCase());
        boolean temp1 = validator.execute("aaaa");
        System.out.println(temp1);


        validator = new Validator(new IsNumberic());
        boolean temp2 = validator.execute("bbbb");
        System.out.println(temp2);
    }



    @Test
    public void test2() {
        Validator validator = new Validator((String s) -> s.matches("[a-z]+"));
        boolean temp1 = validator.execute("aaaa");
        System.out.println(temp1);

        validator = new Validator((String s)->s.matches("\\d+"));
        boolean temp2= validator.execute("bbbb");
        System.out.println(temp2);
    }
}
