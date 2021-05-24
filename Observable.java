package com.example.rxjava_20210519;

/**
 * 具体的被观察者
 */
public abstract class Observable<T> implements ObservableSource{
    @Override
    public void subscribeObserver(Observer observer) {
        //observer.onNext();发消息的功能，这个事由程序员来做
        //所以我们定义一个抽象方法，让程序员调用不同的功能来发消息
        //map,flatmap  concatmap......
        subscribeActual(observer);
    }
    protected abstract void subscribeActual(Observer observer);


    //创建程序使用的接口
    public static<T> Observable create(ObservableOnSubscribe<T> source){
        return new ObservableCreate(source);
    }


    //map操作
    public <U> Observable map(Function<T,U> function){
        return new ObservableMap(this,function);
    }
}









