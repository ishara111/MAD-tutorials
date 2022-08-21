package com.example.tutorial2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class second_ui extends AppCompatActivity {

    private Button metric,imperial;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_ui);

        metric = (Button) findViewById(R.id.metric_button);
        imperial = (Button) findViewById(R.id.imperial_button);

        metric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivityForResult(Third_ui.getIntent(second_ui.this, "metric"), 1);
            }
        });

        imperial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivityForResult(Third_ui.getIntent(second_ui.this, "imperial"), 1);
            }
        });
    }
}
