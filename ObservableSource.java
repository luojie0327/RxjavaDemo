package com.example.rxjava_20210519;

/**
 * 抽象被观察者
 */
public interface ObservableSource<T> {//A<---b
    //add(observer)
    void subscribeObserver(Observer<T> observer);
}
