package com.example.tutorial1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText input1,input2;
    private Button add,subract,mult,divide;;
    private TextView result;
    private double res,num1,num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = (EditText) findViewById(R.id.input1);
        input2 = (EditText) findViewById(R.id.input2);
        add = (Button) findViewById(R.id.add);
        subract = (Button) findViewById(R.id.subract);
        mult = (Button) findViewById(R.id.multiply);
        divide = (Button) findViewById(R.id.divide);
        result = (TextView) findViewById(R.id.output);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getInputs())
                {
                    res = num1 + num2;

                    result.setText(Double.toString(res));
                }
            }
        });
        subract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getInputs())
                {
                    res = num1 - num2;

                    result.setText(Double.toString(res));
                }
            }
        });
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getInputs())
                {
                    res = num1 * num2;

                    result.setText(Double.toString(res));
                }
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getInputs())
                {
                    res = num1 / num2;

                    result.setText(Double.toString(res));
                }
            }
        });

    }
    public boolean getInputs()
    {
        boolean notEmpty = true;
        Editable editable1 = input1.getText();
        Editable editable2 = input2.getText();
        String str1 = editable1.toString();
        String str2 = editable2.toString();
        if ((!str1.isEmpty()) || (!str2.isEmpty()))
        {
            num1 = Double.parseDouble(str1);
            num2 = Double.parseDouble(str2);
        }
        else
        {
            notEmpty = false;
        }
        return notEmpty;
    }
}