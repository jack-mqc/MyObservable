package com.mq.observable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mq.observable.utils.MyObservable;

import org.greenrobot.eventbus.EventBus;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // EventBus.getDefault().post();

        MyObservable.getInstance().addObserver(this);


    }


    @Override
    public void update(Observable observable, Object o) {

    }
}
