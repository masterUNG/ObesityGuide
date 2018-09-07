package com.example.a1010.obesityguide;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListBMIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_bmi);

        //    Create ListView
        createListView();

    //    Back Controller
        backController();

     //   Graph Controller
        graphController();


    }

    private void graphController() {
        Button button = findViewById(R.id.btnGraph);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListBMIActivity.this, GraphActivity.class));
            }
        });
    }

    private void backController() {
        Button button = findViewById(R.id.btnBack);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void createListView() {
        ListView listView = findViewById(R.id.listViewBmi);
        ArrayList<String> dateStringArrayList = new ArrayList<>();
        ArrayList<String> weightStringArrayList = new ArrayList<>();
        ArrayList<String> heightStringArrayList = new ArrayList<>();
        ArrayList<String> bmiStringArrayList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(myOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM userTABLE", null);
        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i += 1) {
            dateStringArrayList.add(cursor.getString(1));
            weightStringArrayList.add(cursor.getString(2));
            heightStringArrayList.add(cursor.getString(3));
            bmiStringArrayList.add(cursor.getString(4));
            cursor.moveToNext();
        }

        BaseAdapter baseAdapter = new BmiAdapter(ListBMIActivity.this, dateStringArrayList, weightStringArrayList, heightStringArrayList, bmiStringArrayList);
        listView.setAdapter(baseAdapter);
    }
}
