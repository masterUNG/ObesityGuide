package com.example.a1010.obesityguide;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;

        import org.w3c.dom.Text;

public class bmi_Valuation extends AppCompatActivity {


    private EditText inheight;
    private EditText inweight;
    private EditText edtResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi__valuation);
        inheight = (EditText) findViewById(R.id.inheight);
        inweight = (EditText) findViewById(R.id.inweight);
        edtResult = (EditText) findViewById(R.id.edtResult);
    }

    public void calculateBMI(View view){
        String heightStr = inheight.getText().toString();
        String weightStr = inweight.getText().toString();

        if (heightStr != null && !"".equals(heightStr)
                && weightStr != null && !"".equals(weightStr)){
            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * heightValue);

            displayBMI(bmi);
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
