package com.example.a1010.obesityguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BmiAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> dateStringArrayList, weightStringArrayList, heightStringArrayList, bmiStringArrayList;

    public BmiAdapter(Context context, ArrayList<String> dateStringArrayList,
                      ArrayList<String> weightStringArrayList,
                      ArrayList<String> heightStringArrayList,
                      ArrayList<String> bmiStringArrayList) {
        this.context = context;
        this.dateStringArrayList = dateStringArrayList;
        this.weightStringArrayList = weightStringArrayList;
        this.heightStringArrayList = heightStringArrayList;
        this.bmiStringArrayList = bmiStringArrayList;
    }

    @Override
    public int getCount() {
        return dateStringArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.listview_bmi, viewGroup, false);

        TextView dateTextView = view1.findViewById(R.id.txtDate);
        TextView weightTextView = view1.findViewById(R.id.txtWeight);
        TextView heightTextView = view1.findViewById(R.id.txtHeight);
        TextView bmiTextView = view1.findViewById(R.id.txtBmi);

        dateTextView.setText(dateStringArrayList.get(i));
        weightTextView.setText("Weight = " + weightStringArrayList.get(i) + "kg.");
        heightTextView.setText("Height = " + heightStringArrayList.get(i) + "cm.");
        bmiTextView.setText("BMI = " + bmiStringArrayList.get(i));

        return view1;
    }
}
