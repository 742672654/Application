package com.example.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.db.MyOpenHelp;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final String TAG="MainActivity";

    private MyOpenHelp myOpenHelp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        myOpenHelp=new MyOpenHelp(this,"QunYou.db",null,2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //第二个参数指定我们菜单项将添加到哪一个菜单对象当中，这里指定的是menu参数
        getMenuInflater().inflate( R.menu.menu_popup,menu );
        return true;//创建的菜单显示出来
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.add_menu:
                Toast.makeText( this,"你点击了add item",Toast.LENGTH_SHORT ).show();
                break;

            case R.id.delete_menu:
                Toast.makeText( this,"你点击了delete item",Toast.LENGTH_SHORT ).show();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected( item );
    }

    @Override
    public void  onClick(View view){

        Toast.makeText(this,"点了一下",Toast.LENGTH_LONG).show();
        SQLiteDatabase database = myOpenHelp.getWritableDatabase();

        switch (view.getId()) {

            case R.id.insertBtn:
                database.execSQL("insert into Book(author, price, name) values('李白', 45.6, '赠汪伦')");
                database.execSQL("insert into Book(author, price, name) values('李高白', 59.6, '赠汪伦2')");
                database.execSQL("insert into Book(author, price, name) values('其他', 596, '哈哈哈')");
                break;

            case R.id.deleteBtn:
                database.execSQL("delete from Book where price=59.6");
                break;

            case R.id.updateBtn:
                database.execSQL("update Book set author ='李白2' where price=59.6");
                break;

            case R.id.queryBtn:
                Cursor cursor = database.rawQuery("select * from Book", null);
                for( cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext() ){

                    int id = cursor.getInt(cursor.getColumnIndex("id"));
                    String author = cursor.getString(cursor.getColumnIndex("author"));
                    double price = cursor.getDouble(cursor.getColumnIndex("price"));
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    Log.v(TAG,"id:"+id+", 作者:"+author+", 价格:"+price+", 书名:"+name);
                }
                cursor.close();
                break;
            default:break;
        }

    }

    private void initView(){
        Button  button = (Button)findViewById(R.id.createBtn);
        Button  insertBtn = (Button)findViewById(R.id.insertBtn);
        Button  deleteBtn = (Button)findViewById(R.id.deleteBtn);
        Button  updateBtn = (Button)findViewById(R.id.updateBtn);
        Button  queryBtn = (Button)findViewById(R.id.queryBtn);
        button.setOnClickListener(this);
        insertBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
        updateBtn.setOnClickListener(this);
        queryBtn.setOnClickListener(this);
    }

}
