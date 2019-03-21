package com.example.myapplication.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyOpenHelp extends SQLiteOpenHelper {

    public static final String CREATE_TEBLE = "create table Book(" +
                                "id integer primary key autoincrement,"+
                                "author text,"+
                                "price real,"+
                                "name text)";

    public MyOpenHelp( Context context, String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TEBLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(" drop table if exists Book");
        onCreate(sqLiteDatabase);
    }
}
