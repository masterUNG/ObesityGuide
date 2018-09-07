package com.example.a1010.obesityguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class brainmanu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brainmanu);
    }

    public void Nexttips1 (View view){
        Button btntips1 = (Button)findViewById(R.id.btntips1);
        Intent intent = new Intent(brainmanu.this,tips1page.class);
        startActivity(intent);
    }

    public void Nexttips2 (View view){
        Button btntips2 = (Button)findViewById(R.id.btntips2);
        Intent intent = new Intent(brainmanu.this,tips2page.class);
        startActivity(intent);
    }

    public void Nexttips3 (View view){
        Button btntips3 = (Button)findViewById(R.id.btntips1);
        Intent intent = new Intent(brainmanu.this,tips3page.class);
        startActivity(intent);
    }

    public void Nexttips4 (View view){
        Button btntips4 = (Button)findViewById(R.id.btntips1);
        Intent intent = new Intent(brainmanu.this,tips4page.class);
        startActivity(intent);
    }

    public void Nexttips5 (View view){
        Button btntips5 = (Button)findViewById(R.id.btntips1);
        Intent intent = new Intent(brainmanu.this,tips5page.class);
        startActivity(intent);
    }
}
