package com.mq.observable.utils;

import android.util.Log;

import java.util.Observable;

/**
 * Created by caiminquan on 2017/9/18.
 */

public class MyObservable extends Observable {

    private static final String TAG  = "PortObservable";

    private volatile static MyObservable instance;

    private MyObservable(){
        //注册消息监听器

    }

    public static MyObservable getInstance(){

        synchronized (MyObservable.class) {
            if (instance == null) {
                instance = new MyObservable();
            }
        }
        return instance;
    }

    public void post(Object object)
    {

        setChanged();
        notifyObservers(object);
    }

    /**
     * 清理消息监听
     */
    public void clear(){

        deleteObservers();
        instance = null;
    }

}
