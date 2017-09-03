package com.Jaycekon.learn;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StreamReduce {

    private static List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
    private static List<Dish> dishes = DishUtil.getDishs();

    @Test
    public void test() {

        //Type 1
        int result = list.stream()
                .reduce(0, Integer::sum);
        System.out.println(result);

        //Type 2
        list.stream()
                .reduce(Integer::sum)
                .ifPresent(System.out::println);


    }

    @Test
    public void maxAndMin() {
        //Max
        list.stream()
                .reduce(Integer::max)
                .ifPresent(System.out::println);

        //Min
        list.stream()
                .reduce(Integer::min)
                .ifPresent(System.out::println);
    }
}
