package com.Jaycekon.stream.Spliterator;

import org.junit.Test;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


/**
 * Created by Jaycekon on 2017/9/23.
 */
public class WorkTest {

    private static final String SENTENCE = " Nel   mezzo del cammin  di nostra  vita " +
            "mi  ritrovai in una  selva oscura" +
            " ché la  dritta via era   smarrita ";


    @Test
    public void test() {
        Stream<Character> stream = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);
        System.out.println("Found " + countWords(stream) + " words");
    }

    @Test
    public void ParallelTest(){
        Stream<Character> stream = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);
        System.out.println("Found " + countWords(stream.parallel()) + " words");
    }


    @Test
    public void ParallTest(){
        Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);

        System.out.println("Found " + countWords(stream) + " words");
    }

    public int countWords(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
                WordCounter::accumulate, WordCounter::combine);
        return wordCounter.getCounter();
    }
}
