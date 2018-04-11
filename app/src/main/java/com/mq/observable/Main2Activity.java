package com.mq.observable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.mq.observable.utils.MyObservable;

import java.util.Observable;
import java.util.Observer;

public class Main2Activity extends AppCompatActivity implements Observer {

    private static final String TAG  = "Main2Activity";

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        MyObservable.getInstance().addObserver(this);

        textView=findViewById(R.id.tv_show);

    }

    @Override
    public void update(Observable observable, Object o) {

        String s=(String)o;

        Log.i(TAG,s);

        final String text=textView.getText().toString()+s+"\n";

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                textView.setText(text);

            }
        });
    }
}
