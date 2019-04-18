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

public class LeftFragment extends Fragment implements View.OnClickListener{

    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        this.mContext = getActivity();

        View view = inflater.inflate(R.layout.fragment_left,container,false);
       // view.findViewById( R.id.left_fragment_btn ).setOnClickListener( this );
        return view;
    }


    @Override
    public void onClick(View v) {

        Toast.makeText( mContext,"左边的Fragment",Toast.LENGTH_SHORT ).show();
    }
}
