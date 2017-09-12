package com.Jaycekon.stream.learn;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StreamFind {
    private static List<Dish> list = DishUtil.getDishs();

    @Test
    public void findAny() {
        list.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(d -> System.out.println(d.getName()));

    }


    @Test
    public void findFirst() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        someNumbers.stream()
                .map(x -> x * x)
                .filter(x -> x % 3 == 0)
                .findFirst()
                .ifPresent(System.out::println);
    }

}
