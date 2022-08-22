package com.example.tutorial2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.slider.Slider;
import com.google.android.material.snackbar.Snackbar;

import java.text.DecimalFormat;

public class Third_ui extends AppCompatActivity {

    private static final DecimalFormat dp = new DecimalFormat("0.00");
    TextView type_text,weight_unit,height_unit;
    EditText weight,height;
    Button next_button;
    Slider weight_slider,height_slider;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_ui);

        type_text = (TextView) findViewById(R.id.type_view);
        weight_unit = (TextView) findViewById(R.id.weight_unit);
        height_unit = (TextView) findViewById(R.id.height_unit);
        next_button = (Button) findViewById(R.id.next_button);
        weight_slider = (Slider) findViewById(R.id.weight_slider);
        height_slider = (Slider) findViewById(R.id.height_slider);
        weight = (EditText) findViewById(R.id.weight);
        height = (EditText) findViewById(R.id.height);

        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        type_text.setText("You have selected\n "+type+" system");

        if (type.equals("metric"))
        {
            weight_unit.setText("KG");
            height_unit.setText("CM");
        }
        if (type.equals("imperial"))
        {
            weight_unit.setText("LB");
            height_unit.setText("Inch");
        }
        weight_slider.addOnSliderTouchListener(new Slider.OnSliderTouchListener() {
            @Override
            public void onStartTrackingTouch(@NonNull Slider slider) {

            }

            @Override
            public void onStopTrackingTouch(@NonNull Slider slider){
                //String value = String.valueOf(slider.getValue());
                weight.setText(String.valueOf(dp.format(slider.getValue())));
            }
        });
        height_slider.addOnSliderTouchListener(new Slider.OnSliderTouchListener() {
            @Override
            public void onStartTrackingTouch(@NonNull Slider slider) {

            }

            @Override
            public void onStopTrackingTouch(@NonNull Slider slider){
                //String value = String.valueOf(slider.getValue());
                height.setText(String.valueOf(dp.format(slider.getValue())));
            }
        });
//        weight_slider.addOnChangeListener(new Slider.OnChangeListener() {
//            @Override
//            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
//                weight.setText(String.valueOf(dp.format(value)));
//            }
//        });
//        height_slider.addOnChangeListener(new Slider.OnChangeListener() {
//            @Override
//            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
//                height.setText(String.valueOf(dp.format(value)));
//            }
//        });

        weight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String value = charSequence.toString();
                if (!value.isEmpty()){

                    if ((Float.parseFloat(value)>= 0.0) && (Float.parseFloat(value)<= 300.0)){

                        weight_slider.setValue(Float.parseFloat(value));
                    }
                    else {
                        Context context = getApplicationContext();
                        CharSequence text = "Weight Must Be Between 0-300";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        weight_slider.setValue(0.0F);
                        weight.setText("");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        height.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String value = charSequence.toString();
                if (!value.isEmpty()){

                    if ((Float.parseFloat(value)>= 0.0) && (Float.parseFloat(value)<= 300.0)){

                        height_slider.setValue(Float.parseFloat(value));
                    }
                    else {
                        Context context = getApplicationContext();
                        CharSequence text = "Height Must Be Between 0-300";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        height_slider.setValue(0.0F);
                        height.setText("");
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    public static Intent getIntent(Context c, String type) {
        Intent intent = new Intent(c, Third_ui.class);
        intent.putExtra("type", type);
        return intent;
    }
}
