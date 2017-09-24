package com.Jaycekon.stream.restructure.Watcher;

import org.junit.Test;

/**
 * Created by Jaycekon on 2017/9/24.
 */
public class ObserverTest {

    @Test
    public void test1() {
        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());
        f.notifyObservers("The queen said her favourite book is Java 8 in Action!");
    }


    @Test
    public void testLambda(){
        Feed feed = new Feed();
        feed.registerObserver((String tweet)->{
            if(tweet != null && tweet.contains("money")){
                System.out.println("Breaking news in NY! " + tweet);
            }
        });

        feed.registerObserver((String tweet)->{
            if(tweet != null && tweet.contains("money")){
                System.out.println("Yet another news in London...    " + tweet);
            }
        });
    }
}
