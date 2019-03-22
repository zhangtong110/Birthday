package com.example.a1.homework3;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

class messageLayout extends RelativeLayout
{
    public messageLayout(Context context, AttributeSet arrs)
    {
        super(context,arrs);
        LayoutInflater.from(context).inflate(R.layout.activity_message,this);
        //LayoutInflater的from方法可以获得一个LayoutInflater对象，之后inflate动态加载布局
        Button titleBack=findViewById(R.id.button3);//下边是对按钮加入监听器也就是功能
        titleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //加入back的处理动作
            }
        });


    }
}
