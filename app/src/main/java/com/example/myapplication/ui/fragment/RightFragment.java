package com.example.myapplication.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.R;

public class RightFragment extends Fragment implements View.OnClickListener{

    private Context mContext;

    //fragment 和Acticity绑定的时候调用，只会调用一次
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    //fragment 初始化的时候调用，只会调用一次
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        this.mContext = getActivity();
        View view = inflater.inflate(R.layout.fragment_right,container,false);
        view.findViewById( R.id.right_fragment_btn ).setOnClickListener( this );
        return view;
    }

    //fragment 初始化视图对象的时候调用
    @Override
    public void onClick(View v) {

        Toast.makeText( mContext,"右边的Fragment",Toast.LENGTH_SHORT ).show();
    }

    //Activity的Created方法执行完毕的时候
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    //fragment由不可见变为可见的时候调用
    @Override
    public void onStart() {
        super.onStart();
    }

    //fragment完全可见的时候调用
    @Override
    public void onResume() {
        super.onResume();
    }

    //fragment依然可见，但是不能喝用户进行交互的时候
    @Override
    public void onPause() {
        super.onPause();
    }

    //fragment完全不可见的时候调用
    @Override
    public void onStop() {
        super.onStop();
    }

    //fragment 视图销毁的时候调用
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    //fragment 销毁的时候调用
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    //fragment 和Activity失去连接的时候
    @Override
    public void onDetach() {
        super.onDetach();
    }
}
