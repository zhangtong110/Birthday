package com.example.a1.homework3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class buttom1 extends AppCompatActivity {
    Button tj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttom1);

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

                Intent i = new Intent(buttom1.this ,MainActivity.class);
////启动
                startActivity(i);
            }
        });
    }
}
