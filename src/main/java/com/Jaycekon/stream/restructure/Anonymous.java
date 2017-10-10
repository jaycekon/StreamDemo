package com.Jaycekon.stream.restructure;

import com.Jaycekon.stream.learn.CaloricLevel;
import com.Jaycekon.stream.learn.Dish;
import com.Jaycekon.stream.learn.DishUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Jaycekon on 2017/9/23.
 */
public class Anonymous {


    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world!");
            }
        };
        r1.run();


        Runnable r2 = () -> System.out.println("hello world!");
        r2.run();
    }


    @Test
    public void test2() {
        List<Dish> menu = DishUtil.getDishs();

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel =
                menu.stream().collect(Collectors.groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }));

        Map<CaloricLevel, List<Dish>> dishesLambda = menu.stream().collect(Collectors.groupingBy(Dish::getCaloricLevel));


        int totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
    }


    @Test
    public void test3(){
        List<Dish> menu = DishUtil.getDishs();

        List<String> dishNames = new ArrayList<>();
        for(Dish dish: menu){
            if(dish.getCalories() > 300){
                dishNames.add(dish.getName());
            } }

        List<String> streamNams = menu.stream()
                .filter(dish -> dish.getCalories()>300)
                .map(Dish::getName)
                .collect(Collectors.toList());

    }
}
