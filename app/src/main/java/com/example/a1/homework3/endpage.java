package com.example.a1.homework3;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;

public class endpage extends AppCompatActivity {
    Button OK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endpage);

        OK=(Button)findViewById(R.id.button6);

        Intent intent = getIntent();
        if (intent != null) {
            // 获取Bundle对象中的参数
            Bundle bundle = intent.getExtras();

            final String name = bundle.getString("name");
            final String date = bundle.getString("date");
            final String gift1 = bundle.getString("gift1");
            final String gift2 = bundle.getString("gift2");
            final String gift3 = bundle.getString("gift3");

            final TextView textView = (TextView) findViewById(R.id.textView7);
            TextView textView2 = (TextView) findViewById(R.id.textView12);
            TextView textView3 = (TextView) findViewById(R.id.textView16);
            TextView textView4 = (TextView) findViewById(R.id.textView17);
            TextView textView5 = (TextView) findViewById(R.id.textView18);

            //在textview中显示出来message

            textView.setText(name);
            textView2.setText(date);
            textView3.setText(gift1);
            textView4.setText(gift2);
            textView5.setText(gift3);

            OK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(endpage.this, Home.class);

                    startActivity(i);

                    MainActivity.flag1=true;
                    MainActivity.number+=1;

                    FileOutputStream fos;

                    try {


                        fos=openFileOutput("new1.json",MODE_APPEND);//把文件输出到data中
                        JSONArray lan=new JSONArray();
                        JSONObject lann=new JSONObject();
                        JSONObject land=new JSONObject();
                        lann.put("name",name);
                        lann.put("birthday",date);
                        lan.put(lann);
                        land.put(String.valueOf(MainActivity.number),lan);

                        fos.write(land.toString().getBytes());//将我们写入的字符串变成字符数组）
                        fos.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

//                    Intent intent = new Intent(endpage.this, Home.class);
//
//                    Bundle bundle = new Bundle();
//                    bundle.putString("name", String.valueOf(name));
//                    bundle.putString("date", String.valueOf(date));
//                    bundle.putString("gift1", String.valueOf(gift1));
//                    bundle.putString("gift2", String.valueOf(gift2));
//                    bundle.putString("gift3", String.valueOf(gift3));
//                    intent.putExtras(bundle);
//                    startActivity(intent);
                }
                });

        }
    }

}

