package com.example.myapplication.gongnen.taigan;


import android.util.Log;

import com.example.myapplication.gongnen.yitiji.DecodeManager;


public class taigan {

    public final static String TAG = "taigan";

    public void tai() {

        Log.e(TAG, "抬杆15");

                        DecodeManager.getinstance().controlPole(1, "192.168.1.199");

        Log.e(TAG, "抬杆成功19");
}
}