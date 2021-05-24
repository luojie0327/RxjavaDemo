package com.example.rxjava_20210519;

public class ObservableCreate<T> extends Observable{

    //这个对象就是用来绑定发射器的
    ObservableOnSubscribe<T> source;

    public ObservableCreate(ObservableOnSubscribe<T> source) {
        this.source = source;
    }

    @Override
    protected void subscribeActual(Observer observer) {
        observer.onSubscribe();
        //需要一个发射器
        CreateEmitter createEmitter=new CreateEmitter(observer);
        source.subscribe(createEmitter);
    }

    /**
     * 发射器的实现类
     */
    static final class CreateEmitter<T> implements Emitter<T>{
        final Observer<T> observer;

        public CreateEmitter(Observer<T> observer) {
            this.observer = observer;
        }

        @Override
        public void onNext(T t) {
            observer.onNext(t);
        }

        @Override
        public void onError(Throwable e) {
            observer.onError(e);
        }

        @Override
        public void onComplete() {
            observer.onComplete();
        }
    }
}









