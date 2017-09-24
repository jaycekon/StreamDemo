package com.Jaycekon.stream.restructure.Watcher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaycekon on 2017/9/24.
 */
public interface Subject {
    void registerObserver(Observer o);

    void notifyObservers(String tweet);


}


class Feed implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObservers(String tweet) {
        this.observers.forEach(o -> o.notify(tweet));
    }
}