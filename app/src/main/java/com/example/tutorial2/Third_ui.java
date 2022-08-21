package com.example.tutorial2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Third_ui extends AppCompatActivity {
    TextView type_text,weight_unit,height_unit;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_ui);

        type_text = (TextView) findViewById(R.id.type_view);
        weight_unit = (TextView) findViewById(R.id.weight_unit);
        height_unit = (TextView) findViewById(R.id.height_unit);

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

    }

    public static Intent getIntent(Context c, String type) {
        Intent intent = new Intent(c, Third_ui.class);
        intent.putExtra("type", type);
        return intent;
    }
}
