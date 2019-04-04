package com.example.myapplication.gongnen.Activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.gongnen.taigan.taigan;


public class HelloActivity  extends AppCompatActivity implements View.OnClickListener{


    private final String TAG="HelloActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    @Override
    public void  onClick(View view){

        Toast.makeText(this,"点了一下", Toast.LENGTH_LONG).show();
        new taigan().tai();
    }

    private void initView(){
        Button button = (Button)findViewById(R.id.createBtn);
        Button  insertBtn = (Button)findViewById(R.id.insertBtn);
        Button  deleteBtn = (Button)findViewById(R.id.deleteBtn);
        Button  updateBtn = (Button)findViewById(R.id.updateBtn);
        Button  queryBtn = (Button)findViewById(R.id.queryBtn);
        button.setOnClickListener(this);
        insertBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
        updateBtn.setOnClickListener(this);
        queryBtn.setOnClickListener(this);
    }






}
