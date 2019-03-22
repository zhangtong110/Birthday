package com.example.a1.homework3;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Home extends AppCompatActivity {
    TextView mainTv;
    Button tj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tj=(Button)findViewById(R.id.button5);
        tj.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            }
        });
        tj.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//Intent是一种运行时绑定（run-time binding）机制，它能在程序运行过程中连接两个不同的组件。

                Intent i = new Intent(Home.this ,MainActivity.class);
////启动
                startActivity(i);
            }
        });


        //获取textView控件 我用的3.0.1版本的AS 如果是以前版本的应该强转
        mainTv = findViewById(R.id.main_tv);
        new TimeThread().start();//启动线程
    }

    //写一个新的线程每隔一秒发送一次消息,这样做会和系统时间相差1秒
    public class TimeThread extends Thread{
        @Override
        public void run() {
            super.run();
            do{
                try {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    msg.what = 1;
                    handler.sendMessage(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }while (true);
        }
    }
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    mainTv.setText(new SimpleDateFormat("yyyy - MM - dd").format(new Date(System.currentTimeMillis())));
                    break;
            }
            return false;
        }
    });


}
