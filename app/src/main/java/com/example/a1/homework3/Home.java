package com.example.a1.homework3;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Home extends AppCompatActivity {
    TextView mainTv;
    Button tj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Gson gson = new Gson();
        String content="";
        try {
            FileInputStream fis=openFileInput("new1.json");
            byte [] buffer=new  byte[fis.available()];
            fis.read(buffer);
            content=new String(buffer);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FileOutputStream iff;
        try {
            JSONObject root = new JSONObject(content);
                    /*FileOutputStream dd;
                    dd=openFileOutput("nameb.json",MODE_PRIVATE);
                    if(MainActivity.number==0){
                        dd.write("".getBytes());
                    }
                    dd.close();*/

//                    TextView t1=(TextView)findViewById(R.id.textView3);
//                    t1.setTextSize(15);
//                    t1.setText(content);
                    /*TextView t1=(TextView)findViewById(R.id.textView3);
                     t1.setTextSize(15);
                     t1.setText(content);*/
                    for (int i=1; i <= MainActivity.number; i++) {



                            JSONArray array = root.getJSONArray(String.valueOf(i));
                            JSONObject lan = array.getJSONObject(0);

                            input(i, lan.getString("name"), lan.getString("birthday"));

                    }
        } catch (JSONException e) {
            e.printStackTrace();

        }
             /* catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/


//        String name=new String();
//        String date=new String();
//        TextView textView1;
//        TextView textView3;
//        TextView textView2;
//        Button button;

        /*if (MainActivity.flag1) {
            Intent intent = getIntent();
            if (intent != null) {
                // 获取Bundle对象中的参数
                Bundle bundle = intent.getExtras();
                name = bundle.getString("name");
                date = bundle.getString("date");
                //在textview中显示出来message
            }
        }*/






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
                Intent i = new Intent(Home.this ,Main3Activity.class);
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

    private void input (int num,String name,String date){
//        String name=new String();
//        String date=new String();
        TextView textView1,textView11,textView22,textView33;
        TextView textView3;
        TextView textView2;
        Button button,button1;
        if (num==1) {
                textView1 = (TextView) findViewById(R.id.textView20);
                textView2 = (TextView) findViewById(R.id.textView19);
                textView3 = (TextView) findViewById(R.id.textView21);
                button = (Button) findViewById(R.id.button7);
                textView1.setText(name);
                textView1.setBackgroundColor(Color.parseColor("#36e5d9"));
                textView2.setText(date);
                textView2.setBackgroundColor(Color.parseColor("#f6e978"));
                textView3.setText("Birthday on :");
                textView3.setBackgroundColor(Color.parseColor("#f6795e"));
                button.setText("EDIT");
                button.setBackgroundColor(Color.parseColor("#ff8d1a"));
        }
            else if(num==2){
            textView11 = (TextView) findViewById(R.id.textView23);
            textView22 = (TextView) findViewById(R.id.textView24);
            textView33 = (TextView) findViewById(R.id.textView22);
            button1 = (Button) findViewById(R.id.button8);
            textView11.setText(name);
            textView11.setBackgroundColor(Color.parseColor("#36e5d9"));
            textView22.setText(date);
            textView22.setBackgroundColor(Color.parseColor("#f6e978"));
            textView33.setText("Birthday on :");
            textView33.setBackgroundColor(Color.parseColor("#f6795e"));
            button1.setText("EDIT");
            button1.setBackgroundColor(Color.parseColor("#ff8d1a"));
        }
        else{}

    }

}
