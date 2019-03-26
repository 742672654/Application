package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class FileActivity extends AppCompatActivity implements View.OnClickListener {


    EditText editText;

    //瞬时数据:保存在内存中
    //持久化:文件储存,Shareprefrence,数据库，sd卡
    //文件储存,java I/O流
    //输入流:读inputStream Reader
    //输出流:写inputStream Writer
    //字符流:Reader Writer
    //字节流:InputStream OutPutSrteam
    //BufferReader(读取一行) BufferWriter
    //SteingBuilder 数据的载体(容器媒介)
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        editText = (EditText)findViewById( R.id.deittext );
        findViewById( R.id.fileWriterbtn ).setOnClickListener( this );
        findViewById( R.id.fileReadbtn ).setOnClickListener( this );
    }

    //MODE_APPEND:文件中有数据，就往里面添加
    //MODE_PRIVATE:有数据就删除，写入自己的数据
    public void writeData(){

        String dataString = editText.getText().toString();
        BufferedWriter bufferedWriter = null;
        Log.v( "输入的内容:",dataString );
        try {
            FileOutputStream fileOutputStream = openFileOutput("data", Context.MODE_PRIVATE);
            OutputStreamWriter OutputStreamWriter = new OutputStreamWriter(fileOutputStream);
            bufferedWriter = new BufferedWriter(OutputStreamWriter);
            bufferedWriter.write( dataString);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufferedWriter!=null) {
                try {
                    bufferedWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //读取
    public void readData(){

        BufferedReader bufferedReader=null;
        try {

            FileInputStream fileInputStream = openFileInput("data");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line="";
            while ((line=bufferedReader.readLine())!=null){

                stringBuilder.append( line );
            }

            Log.v( "读取的内容:",stringBuilder.toString() );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufferedReader!=null) {
                try {
                    bufferedReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.fileWriterbtn:writeData();
                break;

            case R.id.fileReadbtn:readData();
                break;

            default:break;

        }




    }
}
