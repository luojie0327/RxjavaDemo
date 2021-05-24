package com.example.rxjava_20210519;

/**
 * map操作符
 */
public class ObservableMap<T,U> extends AbstractObservableWithUpStream<T,U> {
    final Function<T,U> function;

    public ObservableMap(ObservableSource<T> source, Function<T, U> function) {
        super(source);
        this.function = function;
    }

    @Override
    protected void subscribeActual(Observer observer) {
        source.subscribeObserver(new MapObserver<>(observer,function));
    }

    static final class MapObserver<T,U> extends BasicFuseableObserver<T,U>{

        final Function<T,U> mapper;

        public MapObserver(Observer<U> actual, Function<T, U> function) {
            super(actual);
            this.mapper = function;
        }

        @Override
        public void onNext(T t) {
            //处理过程就留给程序员了
            U apply=mapper.apply(t);
            actual.onNext(apply);
        }
    }
}
