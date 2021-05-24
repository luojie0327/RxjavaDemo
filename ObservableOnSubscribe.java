package com.example.rxjava_20210519;

/**
 * 用来绑定发射器用
 */
public interface ObservableOnSubscribe<T> {
    void subscribe(Emitter<T> emitter);
}
