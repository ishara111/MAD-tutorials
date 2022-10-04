package com.example.tutorial7;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button call = findViewById(R.id.call_btn);
        Button map = findViewById(R.id.map_btn);
        Button thumbnail = findViewById(R.id.capthumb_btn);
        EditText phone = findViewById(R.id.phone_text);
        EditText latitude= findViewById(R.id.latitude);
        EditText longitude = findViewById(R.id.longitude);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!phone.getText().toString().isEmpty())
                {
                    callButtonClicked(Integer.parseInt(phone.getText().toString()));
                }
                else
                {
                    phone.setError("Phone number cannot be empty");
                }
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (latitude.getText().toString().isEmpty()){
                    latitude.setError("latitude cannot be empty");
                }else if(longitude.getText().toString().isEmpty()){
                    longitude.setError("longitude cannot be empty");
                }else
                {
                    viewMapButtonClicked(Double.parseDouble(latitude.getText().toString()),
                            Double.parseDouble(longitude.getText().toString()));
                }
            }
        });

        thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThumbnailPhoto.class);
                startActivity(intent);
            }
        });

    }


    private void callButtonClicked(int phone){
        Uri uri = Uri.parse(String.format("tel:%d", phone));
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(uri);
        startActivity(intent);

    }

    private void viewMapButtonClicked(double latitude,double longitude){

        Uri uri = Uri.parse(String.format("geo:%f,%f", latitude, longitude));
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(uri);
        startActivity(intent);
    }
}