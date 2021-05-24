package com.example.rxjava_20210519;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(Emitter<String> emitter) {
                //发数据的地方
                emitter.onNext("大家好！");
            }
        }).map(new Function<String,String>() {
            @Override
            public String apply(String o) {
                o+="111";
                return o;
            }
        }).map(new Function<String,String>() {
            @Override
            public String apply(String o) {
                o+="22222";
                return o;
            }
        }).map(new Function<String,String>() {
            @Override
            public String apply(String o) {
                o+="3333";
                return o;
            }
        })
                .subscribeObserver(new Observer<String>() {
            @Override
            public void onNext(String o) {
                //收数据的地方
                Log.i("jett","收到了消息："+o);
            }

            @Override
            public void onSubscribe() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}