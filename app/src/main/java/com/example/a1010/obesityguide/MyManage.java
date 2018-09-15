package com.example.a1010.obesityguide;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class MyManage {

    private Context context;
    private myOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public MyManage(Context context) {
        this.context = context;
        myOpenHelper = new myOpenHelper(context);
        sqLiteDatabase = myOpenHelper.getWritableDatabase();
    }

    public long addBmiToSQLite(String dateString,
                               String weightString,
                               String heightString,
                               String bmiString) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("MyDate", dateString);
        contentValues.put("Weight", weightString);
        contentValues.put("Height", heightString);
        contentValues.put("BMI", bmiString);
        return sqLiteDatabase.insert("userTABLE", null, contentValues);
    }



}
