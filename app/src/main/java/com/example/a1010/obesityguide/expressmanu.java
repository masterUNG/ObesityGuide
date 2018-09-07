package com.example.a1010.obesityguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class expressmanu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expressmanu);
    }

    public void BackHome(View view){//กลับหน้าโฮม
        Button btnHome = (Button) findViewById(R.id.btnHome);

        Intent intent= new Intent(expressmanu.this,MainActivity.class);
        startActivity(intent);
    }
}
