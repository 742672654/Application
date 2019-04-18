package com.example.myapplication.intent;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.bean.Intent_cuanzhiBean;


public class Intent_cuanzhi3 extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.intent_cuanzi3);
        Button button = findViewById(R.id.intent_id3);
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
        intent.putExtra("data","页面3返回的参数");
        setResult(2,intent);  //返回数据给所有活动的onActivityResult方法,第一个参数代表ID
        finish();
    }

}
