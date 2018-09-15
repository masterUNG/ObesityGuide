package com.example.a1010.obesityguide;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Calendar;


public class GraphActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        //       Create Graph
        createGraph();
    }



    private void createGraph() {

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(myOpenHelper.database_name, MODE_PRIVATE, null);

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM userTABLE", null);
        cursor.moveToFirst();

        int amountData = cursor.getCount();

        ArrayList<String> weightStringArrayList = new ArrayList<>();

        for (int i=0; i<amountData; i+=1){
            weightStringArrayList.add(cursor.getString(2));
            Log.d("7SepV1", "weight[" + i + "] ==> " + weightStringArrayList.get(i));
            cursor.moveToNext();
        }//ประมวลผลเintเกิน32ใช้long

        DataPoint[] weightDataPoints = new DataPoint[amountData];
        for (int i=0; i<amountData; i+=1) {
            weightDataPoints[i] = new DataPoint(i, Integer.parseInt(weightStringArrayList.get(i)));
        }


        GraphView graphView = findViewById(R.id.graphviewbmi);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(weightDataPoints);
        graphView.addSeries(series);
    }
}
