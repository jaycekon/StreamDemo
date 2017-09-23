package com.Jaycekon.stream.parallel;

import java.util.concurrent.RecursiveTask;

/**
 * Created by Jaycekon on 2017/9/23.
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    private final long[] numbers;
    private final int start;
    private final int end;

    public static final long THRESHOLD = 10_000;


    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            return calculate();
        }
        ForkJoinSumCalculator leftTask =
                new ForkJoinSumCalculator(numbers, start, start + length/2);
        leftTask.fork();

        ForkJoinSumCalculator rightTask =
                new ForkJoinSumCalculator(numbers,start + length/2 +1,end);

        Long rightResult = rightTask.compute();

        Long leftResult = leftTask.join();

        return leftResult + rightResult;
    }

    private long calculate() {
        long num = 0;
        for (int i = start; i < end; i++) {
            num += numbers[i];
        }
        return num;
    }
}
