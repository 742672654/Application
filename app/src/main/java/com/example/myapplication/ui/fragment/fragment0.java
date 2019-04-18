package com.example.myapplication.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.myapplication.R;

public class fragment0 extends AppCompatActivity implements View.OnClickListener {

    //Fragment:更加合理和充分利用屏幕，做到更好的兼容，安卓3.0版本出现
    //  是嵌入在活动中的UI片段，依附于活动的存在而存在，嵌入一个或多个fragment
    //  也可以算是小activity生命周期函数


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragent0);

        findViewById(R.id.left_fragment_btn).setOnClickListener( this );
    }

    int s = 0;
    @Override
    public void onClick(View v) {

        //动态引入
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (s%2==0){
        //add是直接添加,replace是先移除再添加;
        //第二个参数是动态添加的Fragment类
            fragmentTransaction.replace(R.id.right_fragment,new OntherFragment());
            fragmentTransaction.commit();//提交
        }else {

            fragmentTransaction.replace(R.id.right_fragment,new RightFragment());
            fragmentTransaction.commit();//提交
        }
        s++;
    }
}
