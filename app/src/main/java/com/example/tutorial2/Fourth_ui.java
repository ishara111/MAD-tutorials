package com.example.tutorial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Fourth_ui extends AppCompatActivity {

    private static final DecimalFormat dp = new DecimalFormat("0.00");
    String type,weight_unit,height_unit;
    double weight,height,bmi;
    TextView show_weight,show_height,bmi_show,bmi_class,textv3;
    Button plus_btn,minus_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_ui);

        boolean tabletSize = getResources().getBoolean(R.bool.isTablet);
        if (tabletSize) {
            plus_btn = (Button) findViewById(R.id.plus_button);
            minus_btn = (Button) findViewById(R.id.minus_button);

        plus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increaseAllTextSize();
            }
        });
        minus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decreaseAllTextSize();
            }
        });
        }

        Intent intent = getIntent();
        type = intent.getStringExtra("type");
        weight = intent.getDoubleExtra("weight",0);
        height = intent.getDoubleExtra("height", 0);

        show_weight = (TextView) findViewById(R.id.show_weight);
        show_height = (TextView) findViewById(R.id.show_height);
        textv3 = (TextView) findViewById(R.id.textView3);
        bmi_show = (TextView) findViewById(R.id.bmi_show);
        bmi_class = (TextView) findViewById(R.id.bmi_class);

        if (type.equals("metric")){
            weight_unit = "KG";
            height_unit = "CM";
            bmi = weight / Math.pow((height/100),2);
        }
        if (type.equals("imperial")){
            weight_unit = "LB";
            height_unit = "Inch";
            bmi = (weight / Math.pow((height),2))*703;
        }

        String weight_string = "Your weight is " +weight+ " "+weight_unit;
        String height_string = "Your height is " +height+ " "+height_unit;
        show_weight.setText(weight_string);
        show_height.setText(height_string);
        bmi_show.setText(String.valueOf(dp.format(bmi)));

        if (bmi < 18.5){
            bmi_class.setText("Underweight");
            bmi_class.setBackgroundColor(Color.parseColor("#BF360C"));

        }else if ((bmi>=18.5) && (bmi<=24.99)){
            bmi_class.setText("Healthy weight");
            bmi_class.setBackgroundColor(Color.GREEN);
        }else if ((bmi>=25) && (bmi<=29.99)) {
            bmi_class.setText("Overweight but not obese");
            bmi_class.setBackgroundColor(Color.parseColor("#bfff00"));
        }else if ((bmi>=30) && (bmi<=34.99)) {
            bmi_class.setText("Obese class I");
            bmi_class.setBackgroundColor(Color.YELLOW);
        }else if ((bmi>=35) && (bmi<=39.99)) {
            bmi_class.setText("Obese class II");
            bmi_class.setBackgroundColor(Color.parseColor("#ff8000"));
        }else if (bmi>=40) {
            bmi_class.setText("Obese class III");
            bmi_class.setBackgroundColor(Color.RED);
        }

    }

    public static Intent getIntent(Context c, String type,double weight, double height) {
        Intent intent = new Intent(c, Fourth_ui.class);
        intent.putExtra("type", type);
        intent.putExtra("weight", weight);
        intent.putExtra("height", height);
        return intent;
    }

    private void increaseAllTextSize(){
        float size1=show_weight.getTextSize();
        float size2=show_height.getTextSize();
        float size3=textv3.getTextSize();
        float size4=bmi_show.getTextSize();
        float size5=bmi_class.getTextSize();
        Log.d("size", "increaseText: "+size1);
        Log.d("size", "increaseText: "+size2);
        Log.d("size", "increaseText: "+size3);
        Log.d("size", "increaseText: "+size4);
        Log.d("size", "increaseText: "+size5);
        show_weight.setTextSize(TypedValue.COMPLEX_UNIT_PX, size1*1.1F);
        show_height.setTextSize(TypedValue.COMPLEX_UNIT_PX, size2*1.1F);
        textv3.setTextSize(TypedValue.COMPLEX_UNIT_PX, size3*1.1F);
        bmi_show.setTextSize(TypedValue.COMPLEX_UNIT_PX, size4*1.1F);
        bmi_class.setTextSize(TypedValue.COMPLEX_UNIT_PX, size5*1.1F);
    }
    private void decreaseAllTextSize(){
        float size1=show_weight.getTextSize();
        float size2=show_height.getTextSize();
        float size3=textv3.getTextSize();
        float size4=bmi_show.getTextSize();
        float size5=bmi_class.getTextSize();
        Log.d("size", "decreaseText: "+size1);
        Log.d("size", "decreaseText: "+size2);
        Log.d("size", "decreaseText: "+size3);
        Log.d("size", "decreaseText: "+size4);
        Log.d("size", "decreaseText: "+size5);
        show_weight.setTextSize(TypedValue.COMPLEX_UNIT_PX, size1*0.9F);
        show_height.setTextSize(TypedValue.COMPLEX_UNIT_PX, size2*0.9F);
        textv3.setTextSize(TypedValue.COMPLEX_UNIT_PX, size3*0.9F);
        bmi_show.setTextSize(TypedValue.COMPLEX_UNIT_PX, size4*0.9F);
        bmi_class.setTextSize(TypedValue.COMPLEX_UNIT_PX, size5*0.9F);
    }
}