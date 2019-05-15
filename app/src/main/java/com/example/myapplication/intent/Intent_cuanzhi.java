package com.example.myapplication.intent;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.myapplication.R;
import com.example.myapplication.bean.Intent_cuanzhiBean;


public class Intent_cuanzhi extends AppCompatActivity implements View.OnClickListener {

    //intent 是各种组建之间进行交互的一种重要方式
    //       不仅能够表明当前组件想要执行的动作 还可以在不同组件之间进行数据的传递
    //       分为显式intent 和隐式intent
    //       不仅可以启动活动还可以发送广播 和启动服务
    //       intent 虽然强大但是用法及其简单


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_cuanzi);
        Button button = findViewById(R.id.intent_id);
        button.setOnClickListener(this);

        Button button2 = findViewById(R.id.intent2_id);
        button2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {


        SharedPreferences spf = getApplicationContext().getSharedPreferences("zld_config",Context.MODE_PRIVATE);
        SharedPreferences.Editor spfEdit = spf.edit();
        spfEdit.putBoolean("is_first", false);
        spfEdit.commit();


        SharedPreferences sp = getApplicationContext().getSharedPreferences("zld_config", Context.MODE_MULTI_PROCESS);


        Toast.makeText( this,sp.getBoolean("yessir", false)+"",Toast.LENGTH_SHORT ).show();







// TODO:  显式 Intent
//         Intent intent = new Intent(Intent_cuanzhi.this, Intent_cuanzhi2.class);
//         startActivity(intent);

// TODO:  隐式 Intent
//         Intent intent = new Intent("android.intent.action.Intent_cuanzhi2.cesi");
//         intent.addCategory("android.intent.category.Intent_cuanzhi2.cesi");
//         startActivity(intent);

// TODO:  系统内置一个动作（启动浏览器打开某个网站）
//         Intent intent = new Intent(Intent.ACTION_VIEW);
//         intent.setData(Uri.parse("http://www.baidu.com"));
//         startActivity(intent);

// TODO:  Intent传递数据
        Intent intent = new Intent(Intent_cuanzhi.this,v.getId()==R.id.intent_id? Intent_cuanzhi2.class:Intent_cuanzhi3.class);
        intent.putExtra("s1","这个是s1");
        intent.putExtra("s2",'A');
        intent.putExtra("s3",465465);

        Intent_cuanzhiBean intentBean = new Intent_cuanzhiBean();
        intentBean.setAge(20);
        intentBean.setName("姓名");
        intent.putExtra("intentBean",intentBean);
        // startActivity(intent); //普通启动活动

        //带ID的启动活动，用于后期判断活动来自哪里启动的
        if (v.getId()==R.id.intent_id){
            startActivityIfNeeded(intent,1);
        }else{
            startActivityIfNeeded(intent,2);
        }

    }

    /**
     * TODO:  活动返回时调用方法
     * @param requestCode 调用活动时传的值
     * @param resultCode 返回活动时传的值
     * @param data  Intent对象
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 1 :
                if (resultCode == RESULT_OK){

                     String data_cuanzi = data.getStringExtra("data");
                     Toast.makeText(getBaseContext(), data_cuanzi,Toast.LENGTH_SHORT).show();
                }break;

            case 2 :
                if (resultCode == 2){

                    String data_cuanzi = data.getStringExtra("data");
                    Toast.makeText(getBaseContext(), data_cuanzi,Toast.LENGTH_SHORT).show();
                }break;
        }
    }

}
