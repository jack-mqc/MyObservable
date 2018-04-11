package com.mq.observable;

import android.app.Application;
import android.util.Log;

import com.mq.observable.utils.MyObservable;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by HZJ on 2018/4/11.
 */

public class App extends Application {

    private static final String TAG  = "App";

    int count=0;

    @Override
    public void onCreate() {
        super.onCreate();

        startTimer();

    }

    private void startTimer() {

        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {

                count++;

                String s="定时器已执行"+count+"次";
                Log.i(TAG,s);
                MyObservable.getInstance().post(s);


            }
        };

        Timer timer=new Timer();

        timer.schedule(timerTask,5000,5000);



    }
}
