package com.Jaycekon.number;

import com.Jaycekon.learn.Dish;
import com.Jaycekon.learn.DishUtil;
import org.junit.Test;

import java.util.List;
import java.util.OptionalInt;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Jaycekon on 2017/9/3.
 */
public class NumberStream {
    private static List<Dish> list = DishUtil.getDishs();


    /**
     * 计算所有食物的卡路里之和
     */
    @Test
    public void sumCalories() {
        //Type 1
        int calories = list.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println(calories);


        //Type 2
        int result = list.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println(result);
    }


    /**
     * 转换回对象流
     */
    @Test
    public void boxed() {
        IntStream intStream = list.stream()
                .mapToInt(Dish::getCalories);

        Stream<Integer> stream = intStream.boxed();

        int result = stream.reduce(0, Integer::sum);

        System.out.println(result);
    }


    /**
     * 默认值 OptionalInt
     */
    @Test
    public void optionalInt() {
        OptionalInt optionalInt = list.stream()
                .mapToInt(Dish::getCalories)
                .max();
        System.out.println(optionalInt.orElse(1));
    }


    /**
     * 随机生成100个数字
     */
    @Test
    public void randCode() {
        List<Dish> nums = IntStream.rangeClosed(1, 100).boxed()
                .map(Dish::new)
                .collect(Collectors.toList());

        nums.forEach(System.out::println);
    }


    /**
     * 生成100 以内的勾股数
     */
    @Test
    public void gouGu() {
        // Type 1
        Stream<int[]> stream = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                );

        System.out.println("Type 1");
        stream.limit(5).forEach(t -> System.out.println(t[0] + "," + t[1] + "," + t[2]));


        // Type 2

        System.out.println("Type 2");
        Stream<double[]> doubleStream = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                                .filter(t -> t[2] % 1 == 0)
                );

        doubleStream.limit(5).forEach(t -> System.out.println(t[0] + "," + t[1] + "," + t[2]));
    }


    @Test
    public void fbonacci() {
        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1], t[0] + t[1]})
                .map(t -> t[0])
                .limit(20)
                .forEach(n -> System.out.print(n + ","));
    }



    @Test
    public void generate(){
        IntSupplier intSupplier = new IntSupplier() {
            private int previous=0;
            private int current =1;
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                System.out.println("previous:"+this.previous+",current:"+this.current);
                return oldPrevious;
            }
        };

        IntStream.generate(intSupplier).limit(10).forEach(System.out::print);



    }
}
