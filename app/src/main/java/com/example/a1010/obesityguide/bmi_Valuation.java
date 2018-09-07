package com.example.a1010.obesityguide;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.text.method.MovementMethod;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

        import org.w3c.dom.Text;

        import java.text.DateFormat;
        import java.text.SimpleDateFormat;
        import java.util.Calendar;

public class bmi_Valuation extends AppCompatActivity {


    private EditText inheight;
    private EditText inweight;
    private TextView edtResult;
    private String dateString, weightString, heightString, myBMIstring;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi__valuation);
        inheight = (EditText) findViewById(R.id.inheight);
        inweight = (EditText) findViewById(R.id.inweight);
        edtResult = findViewById(R.id.edtResult);

//        Show Date
        showDate();

//        Show ListView
        showListView();


    } //main method

    private void showListView() {
        Button button =  findViewById(R.id.btnReset);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //            Move to ListBmi

                startActivity(new Intent(bmi_Valuation.this,ListBMIActivity.class));

            }
        });
    }

    private void showDate() {
        TextView textView= findViewById(R.id.txtDate);

        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        dateString = dateFormat.format(calendar.getTime());
        textView.setText(dateString);

    }

    public void calculateBMI(View view){
        String heightStr = inheight.getText().toString();
        String weightStr = inweight.getText().toString();

        weightString = weightStr;
        heightString = heightStr;

        if (heightStr != null && !"".equals(heightStr)
                && weightStr != null && !"".equals(weightStr)){
            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * heightValue);

            displayBMI(bmi);

            myBMIstring = Float.toString(bmi);


 //           Update SQLite คือ ฐานข้อมูลขนาดเล็กในมือถือ
            MyManage myManage = new MyManage(bmi_Valuation.this);
            myManage.addBmiToSQLite(dateString, weightString, heightString, myBMIstring);

//            Clear TextField
            inheight.setText("");
            inweight.setText("");

        }
    }
    private void displayBMI(float bmi) {
        String bmiLabel = "";

        if (Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = getString(R.string.very_severely_underweight);
        } else if (Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi, 24.9f) <= 0) {
            bmiLabel = getString(R.string.normal);
        } else if (Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 29.9f) <= 0) {
            bmiLabel = getString(R.string.obese_class_i);
        }else if (Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 34.9f) <= 0) {
            bmiLabel = getString(R.string.obese_class_ii);
        }else if (Float.compare(bmi, 35f) > 0 && Float.compare(bmi, 39.9f) <= 0) {
            bmiLabel = getString(R.string.obese_class_iii);
        }else {
            bmiLabel = getString(R.string.obese_class_iiii);
        }

        bmiLabel = bmi + "\n\n" + bmiLabel;
        edtResult.setText(bmiLabel);
    }
}
