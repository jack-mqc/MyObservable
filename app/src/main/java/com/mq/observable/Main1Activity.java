package com.mq.observable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.mq.observable.utils.MyObservable;

import java.util.Observable;
import java.util.Observer;

public class Main1Activity extends AppCompatActivity implements Observer {

    private static final String TAG  = "Main1Activity";

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        //为MyObservable添加观察者
        MyObservable.getInstance().addObserver(this);

        textView=findViewById(R.id.tv_show);

        findViewById(R.id.btn_action).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main1Activity.this,Main2Activity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onDestroy() {

        MyObservable.getInstance().deleteObserver(this);

        super.onDestroy();
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
