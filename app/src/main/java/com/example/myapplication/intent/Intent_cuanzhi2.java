package com.example.myapplication.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.bean.Intent_cuanzhiBean;

public class Intent_cuanzhi2 extends AppCompatActivity implements View.OnClickListener {

    //intent 是各种组建之间进行交互的一种重要方式
    //       不仅能够表明当前组件想要执行的动作 还可以在不同组件之间进行数据的传递
    //       分为显式intent 和隐式intent
    //       不仅可以启动活动还可以发送广播 和启动服务
    //       intent 虽然强大但是用法及其简单

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.intent_cuanzi2);
        button = findViewById(R.id.intent_id2);
        button.setOnClickListener(this);


        Intent intent = getIntent();

        String s1 = intent.getStringExtra("s1");
        char s2 = intent.getCharExtra("s2",'0');
        int s3 = intent.getIntExtra("s3",0);

        Intent_cuanzhiBean intentBean = (Intent_cuanzhiBean) intent.getSerializableExtra("intentBean");


        Toast.makeText(getBaseContext(), s1+"--"+s2+"--"+s3+"--"+intentBean.toString(),Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onClick(View v) {

        Intent intent = new Intent();
        intent.putExtra("data","页面2返回的参数");
        setResult(RESULT_OK,intent);  //返回数据给所有活动的onActivityResult方法
        finish();
    }




}
