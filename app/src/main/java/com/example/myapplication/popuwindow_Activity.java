package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

public class popuwindow_Activity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popuwindow_layout1);
        button = findViewById(R.id.btn_add);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //获取自定义的菜单布局文件
        View inflate = getLayoutInflater().inflate(R.layout.popuwindow_layout,null,false);
        //创建popupwindow的实例
        popupWindow = new PopupWindow(inflate, ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT,true);
        //设置PopupWindow显示在按钮的下面
        popupWindow.showAsDropDown(button,0,0);

        //单机其他地方消失
        inflate.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View view, MotionEvent notionEvent) {
                //如果菜单存在并且为显示状态，就关闭菜单，并且初始化菜单
                if(popupWindow!=null && popupWindow.isShowing()){
                    popupWindow.dismiss();
                    popupWindow=null;
                }
                return false;
            }
        });

    }
}
