package com.example.myapplication.guangbo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {


        Toast.makeText(context,"MyReceiver2静态注册的广播收到了",Toast.LENGTH_SHORT).show();
        abortBroadcast();//中断广播向下传播
    }
}
