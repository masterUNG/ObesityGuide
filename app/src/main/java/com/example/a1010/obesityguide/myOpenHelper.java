package com.example.a1010.obesityguide;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class myOpenHelper extends SQLiteOpenHelper{

    private Context context;
    public static final String database_name = "Bmi.db";
    private static final int database_version = 1;
    private static final String create_user = "create table userTABLE (" +
            "id integer primary key, " +
            "MyDate text, " +
            "Weight text, " +
            "Height text, " +
            "BMI text);";

    public myOpenHelper(Context context) {
        super(context, database_name, null, database_version);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(create_user);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
} // Main Class
