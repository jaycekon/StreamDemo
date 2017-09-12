package com.Jaycekon.stream.parallel;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * Created by weijie_huang on 2017/9/12.
 */
public class ParallelTest {

    @Test
    public void parallelSum() {
        long start = System.currentTimeMillis();
        Stream.iterate(1L, i -> i + 1)
                .limit(100)
                .reduce(Long::sum)
                .ifPresent(System.out::println);

        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        Stream.iterate(1L, i -> i + 1)
                .limit(100)
                .parallel()
                .reduce(Long::sum)
                .ifPresent(System.out::println);

        System.out.println(System.currentTimeMillis() - start);

    }
}
