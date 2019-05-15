package com.example.myapplication.ui.listView;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class listView extends AppCompatActivity {

    ListView listView;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        listView = findViewById(R.id.listview);

// TODO  系统配置器
//        //第一步：准备数据源
//        String[] dataString = {"张三","李四","王五","张三","李四","王五","张三","李四","王五","张三","李四","王五","张三","李四","王五",
//                "张三","李四","王五","张三","李四","王五","张三","李四","王五"};
//        //第二步：创建适配器
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,dataString);
//        //第三步：绑定适配器
//        listView.setAdapter(arrayAdapter);

// TODO  自定义配置器
        //第一步：准备数据源
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>> ();
        Map<String,Object> map = new HashMap<String,Object>();
            map.put("logo1",R.mipmap.logo1);
            map.put("item_title1","360卫士");
            map.put("item_title2","80.5分");
            map.put("item_title3","80亿人的选择");
        list.add(map);

        Map<String,Object> map2 = new HashMap<String,Object>();
            map2.put("logo1",R.mipmap.logo2);
            map2.put("item_title1","腾讯手机卫士");
            map2.put("item_title2","98.5分");
            map2.put("item_title3","70万人不选择");
        list.add(map2);

        //第二步：创建适配器,存入数据
        MyAdapter myAdapter = new MyAdapter(this);
        myAdapter.setList(list);

        //第三步：绑定适配器
        listView.setAdapter(myAdapter);


    }




}
