package com.example.myapplication.ui.listView;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;
import java.util.Map;


public class MyAdapter extends BaseAdapter {



    List<Map<String,Object>> list;  //数据源与配置器建立连接
    LayoutInflater layoutInflater;//初始化布局填充器

    public MyAdapter(Context context) {
        this.layoutInflater = layoutInflater.from(context);
    }

    public List<Map<String, Object>> getList() {
        return list;
    }
    public void setList(List<Map<String, Object>> list) {
        this.list = list;
    }

    //itme的数量
    @Override
    public int getCount() {
        return list.size();
    }

    //返回第几条itme信息
    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    //返回itme的ID
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //第三个参数false：不会为item添加父布局
        View view1 = layoutInflater.inflate(R.layout.listview_item,viewGroup,false);
        ImageView logo1 = view1.findViewById(R.id.logo1);
        TextView item_title1 = view1.findViewById(R.id.item_title1);
        TextView item_title2 = view1.findViewById(R.id.item_title2);
        TextView item_title3 = view1.findViewById(R.id.item_title3);

        Map<String,Object> map = list.get(i);

        logo1.setImageResource((int)map.get("logo1"));
        item_title1.setText((String)map.get("item_title1"));
        item_title2.setText((String)map.get("item_title2"));
        item_title3.setText((String)map.get("item_title3"));

        return view1;
    }
}
