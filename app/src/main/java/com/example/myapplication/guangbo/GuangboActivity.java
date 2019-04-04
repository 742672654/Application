package com.example.myapplication.guangbo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.gongnen.taigan.taigan;

public class GuangboActivity extends AppCompatActivity implements View.OnClickListener {

    //1.标准广播:特点一个完全异步执行的广播，广播一发出，所有的广播接受者都能收到，没有先后顺序
    //2.有序广播:特点同步执行的广播，同一时刻有一个广播接受者来接收这个广播，处理逻辑之后在向下传递这个广播
    //3.系统广播:锁屏，开机，网络的变化(广播是由系统发出，只需要关心接收即可)
    // 注册方式:动态注册(java) 静态注册在我们的清单文件中
    // 广播接受者 extends BroadcastReceiver 实现onReceive() 自动执行，无需手动调用
    //动态注册的关公需要取消注册，一般写在onDestroy()方法里面
    //广播是可以跨进程(程序)

    //4.本地广播:只能在本应用程序之间传递，效率更高
    //          LocalBroadcastReceiver 本地广播 动态注册

    MyBroadCastReceiver myBroadCastReceiver;
    LocalBroadCastReceiver localBroadCastReceiver;
    LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guangbo);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");//系统广播:网络变化
        myBroadCastReceiver = new MyBroadCastReceiver(); //广播接受者
        registerReceiver(myBroadCastReceiver,intentFilter);

        Button button1 = (Button)findViewById(R.id.guangbo);
        button1.setOnClickListener(this);

        Button button2 = (Button)findViewById(R.id.guangbo2);
        button2.setOnClickListener(this);

        //获取本地广播管理者
        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        //注册本地广播
        localBroadCastReceiver = new LocalBroadCastReceiver(); //广播接受者
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("com.example.myapplication.guangbo_local");//系统广播:网络变化
        localBroadcastManager.registerReceiver(localBroadCastReceiver,intentFilter2);

    }


    @Override
    public void onClick(View v) {


        if(v.getId()== R.id.guangbo){

            Intent intent = new Intent("com.example.myapplication.guangbo_me");
            intent.putExtra("Broad","如果接受到这条消息，就实现了组建的通讯");
            //sendBroadcast(intent);    //发送标准广播
            sendOrderedBroadcast(intent,null);  //发送有序广播
        }else{ //发送本地广播

            Toast.makeText(this,"发送本地广播",Toast.LENGTH_SHORT).show();

            Intent intent = new Intent("com.example.myapplication.guangbo_local");
            intent.putExtra("Broad","本地广播通讯");
            localBroadcastManager.sendBroadcast(intent);
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myBroadCastReceiver);

        localBroadcastManager.unregisterReceiver(localBroadCastReceiver);
    }


    class MyBroadCastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            Toast.makeText(context,"网络发生变化",Toast.LENGTH_SHORT).show();
            ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if( activeNetworkInfo != null && activeNetworkInfo.isAvailable()){
                Toast.makeText(context,"当前网络可用",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context,"当前网络不可用",Toast.LENGTH_SHORT).show();
            }
        }

    }

    class LocalBroadCastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {


            Toast.makeText(context,intent.getStringExtra("Broad"),Toast.LENGTH_SHORT).show();

        }

    }


}
