package com.Jaycekon.stream.learn;

import org.junit.Test;

import java.util.List;

public class StreamMatch {

    private static List<Dish> list =  DishUtil.getDishs();


    @Test
    public void AnyMatch(){

        if (list.stream().anyMatch(Dish::isVegetarian)){
            System.out.printf("The menu is (somewhat) vegetarian friendly!!");
        }

    }


    @Test
    public void AllMatch(){

        boolean flag = list.stream().allMatch(dish -> dish.getCalories() <1000);
        System.out.println(flag);
    }


    @Test
    public void NoneMatch(){
        boolean flag = list.stream().noneMatch(dish -> dish.getCalories() <1000);
        System.out.println(flag);
    }
}
