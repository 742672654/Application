package com.example.myapplication.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.myapplication.R;

public class KongjianActicity extends AppCompatActivity implements View.OnClickListener{

    Button button;
    ImageView imageView;
    EditText editText;
    ProgressBar progressBar;


    @Override
    public void onCreate(Bundle v) {
        super.onCreate(v);
        setContentView( R.layout.kongjian);
        button = findViewById( R.id.kongjian_id );
        button.setOnClickListener( this );
        imageView =  findViewById( R.id.kongjian_img );
        editText = findViewById( R.id.kongjina_edit );
        progressBar = findViewById( R.id.kongjina_ProgressBar );
    }

    @Override
    public void onClick(View v) {

        //修改图片的url
        imageView.setImageResource( R.mipmap.tu1 );
        //获取editText里面的内容
        String edirtString = editText.getText().toString();
        Toast.makeText( this,edirtString,Toast.LENGTH_SHORT ).show();

        //点击让progressBar是否可见进行切换

        if (progressBar.getVisibility() == View.GONE){
            progressBar.setVisibility( View.VISIBLE  );
        }else {
            progressBar.setVisibility( View.GONE  );
        }

        //构建AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(KongjianActicity.this );
        builder.setTitle( "啊这个是AlertDialog的Title" );
        builder.setMessage( "这个是正文内容" );
        builder.setCancelable( false );
        builder.setPositiveButton( "ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //根据要求进行一些逻辑处理
                Toast.makeText( KongjianActicity.this,"你点击了AlertDialog的 OK 按钮",Toast.LENGTH_SHORT ).show();
            }
        } );

        builder.setNegativeButton( "NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //根据要求进行一些逻辑处理
                Toast.makeText( KongjianActicity.this,"你点击了AlertDialog的 NO 按钮",Toast.LENGTH_SHORT ).show();
            }
        } );
        builder.show();


        ProgressDialog progressDialog = new ProgressDialog( KongjianActicity.this );
        progressDialog.setTitle( "ProgressDialog的 Title " );
        progressDialog.setMessage( "ProgressDialog的 内容" );
        progressDialog.show();

    }


}
