package com.Jaycekon.stream.parallel;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by weijie_huang on 2017/9/12.
 */
public class ParallelTest {

    @Test
    public void parallelSum() {
        System.out.println("Parallel range sum done in:" + measureSumPerf(ParallelTest::rangedSum, 10_000_000) + " msecs");


    }


    @Test
    public void parallelSums(){
        System.out.println("Parallel range sum done in:" + measureSumPerf(ParallelTest::parallelRangedSum, 10_000_000) + " msecs");
    }


    @Test
    public void testForkJoin(){
        long start = System.currentTimeMillis();
        long result = forkJoinSum(10_000_000);


        System.out.println(System.currentTimeMillis() - start);
        System.out.println(result);
    }


    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }


    public long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }


    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
    }


    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(0,Long::sum);
    }

}
