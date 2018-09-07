package com.example.a1010.obesityguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //go all page
    public void NextBmi (View view){
        Button btnBmi = (Button)findViewById(R.id.btnBmi);
        Intent intent = new Intent(MainActivity.this,bmi_Valuation.class);
        startActivity(intent);
    }

    public void NextEat (View view){
        Button btnEat = (Button)findViewById(R.id.btnEat);
        Intent intent = new Intent(MainActivity.this,eatmanu.class);
        startActivity(intent);
    }

    public void NextBurn (View view){
        Button btnBurn = (Button)findViewById(R.id.btnBurn);
        Intent intent = new Intent(MainActivity.this,burnmanu.class);
        startActivity(intent);
    }


    public void NextBrain (View view){
        Button btnBrain = (Button)findViewById(R.id.btnBrain);
        Intent intent = new Intent(MainActivity.this,brainmanu.class);
        startActivity(intent);
    }
}
