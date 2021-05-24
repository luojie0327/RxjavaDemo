package com.example.rxjava_20210519;

/**
 * 抽象观察者
 */
public interface Observer<T> {
    //接收消息   update()
    void onNext(T t);
    //建立关联时回调   observable.add(observer)
    void onSubscribe();
    //异常
    void onError(Throwable e);
    //接收消息完成
    void onComplete();

}
