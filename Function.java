package com.example.rxjava_20210519;

/**
 * map事件变换的核心API
 */
public interface Function<T,R> {
    //T  就是上游来的数据
    //R  就是传递到下游的数据
    R apply(T t);
}
