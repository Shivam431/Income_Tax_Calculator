package com.example.income_tax_calculator;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6,e7;
    TextView t1;
    Button b;
    RadioGroup rg;
    RadioButton rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1=(EditText)findViewById(R.id.editText2);
                e2=(EditText)findViewById(R.id.editText3);
                e3=(EditText)findViewById(R.id.editText4);
                e4=(EditText)findViewById(R.id.editText5);
               e5=(EditText)findViewById(R.id.editText8);
                e6=(EditText)findViewById(R.id.editText6);
                e7=(EditText)findViewById(R.id.editText7);
                t1=(TextView)findViewById(R.id.textView11);
                rg=(RadioGroup)findViewById(R.id.grp);
                int id=rg.getCheckedRadioButtonId();
                rb=(RadioButton)findViewById(id);
                String city = rb.getText().toString();
                float a = Float.parseFloat(e6.getText().toString());
                float sal = Float.parseFloat(e1.getText().toString());
                float hra = Float.parseFloat(e2.getText().toString());
                float special = Float.parseFloat(e3.getText().toString());
                float lta = Float.parseFloat(e4.getText().toString());
                float rent = Float.parseFloat(e7.getText().toString());
                float bill = Float.parseFloat(e5.getText().toString());
                if (a <= 60) {
                    float hraDeduct;
                    float hra1 = hra * 12;
                    float rent1 = (float) (rent * 12 - 0.1 * sal * 12);
                    float citySal;
                    if (city.equalsIgnoreCase("Urban")) {
                        citySal = (float) (0.5 * sal * 12);
                    } else {
                        citySal = (float) (0.4 * sal * 12);
                    }
                    if (rent1 < citySal) {
                        hraDeduct = rent1;
                    } else {
                        hraDeduct = citySal;
                    }
                    float gross = (sal * 12) + (hra1 - hraDeduct) + special*12 + (lta - bill) - 50000;
                    if (gross <= 250000) {
                        float tax=0;
                        t1.setText(String.valueOf(tax));
                    } else if (gross > 250000 && gross <= 500000) {
                        float tax = (float) (0.05 * gross);
                        t1.setText(String.valueOf(tax));
                    } else if (gross > 500000 && gross <= 1000000) {
                        float tax = (float) (0.2 * gross);
                        t1.setText(String.valueOf(tax));
                    } else if (gross > 1000000) {
                        float tax = (float) (0.3 * gross);
                        t1.setText(String.valueOf(tax));
                    }

                }
                else if (a > 60 && a < 80) {
                    float hraDeduct;
                    float hra1 = hra * 12;
                    float rent1 = (float) (rent * 12 - 0.1 * sal * 12);
                    float citySal;
                    if (city.equalsIgnoreCase("Urban")) {
                        citySal = (float) (0.5 * sal * 12);
                    } else{
                        citySal = (float) (0.4 * sal * 12);
                    }
                    if (rent1 < citySal) {
                        hraDeduct = rent1;
                    } else {
                        hraDeduct = citySal;
                    }
                    float gross = (sal * 12) + (hra1 - hraDeduct) + special*12 + (lta - bill) - 50000;

                    if (gross <= 300000) {
                        float tax = 0;
                        t1.setText(String.valueOf(tax));
                    } else if (gross > 300000 && gross <= 500000) {
                        float tax = (float) (0.05 * (gross - 300000) + 0.04 * 100);
                        t1.setText(String.valueOf(tax));
                    } else if (gross > 500000 && gross <= 1000000) {
                        float tax = (float) (10000 + (0.2 * (gross - 500000)) + 0.04 * 1100);
                        t1.setText(String.valueOf(tax));
                    } else if (gross > 1000000) {
                        float tax = (float) (110000 + (0.3 * (gross - 1000000)) + 0.04 * 2600);
                        t1.setText(String.valueOf(tax));
                    }

                }
                else if (a > 80) {
                    float hraDeduct;
                    float hra1 = hra * 12;
                    float rent1 = (float) (rent * 12 - 0.1 * sal * 12);
                    float citySal;
                    if (city.equalsIgnoreCase("Urban") ) {
                        citySal = (float) (0.5 * sal * 12);
                    } else {
                        citySal = (float) (0.4 * sal * 12);
                    }
                    if (rent1 < citySal) {
                        hraDeduct = rent1;
                    } else {
                        hraDeduct = citySal;
                    }
                    float gross = (sal * 12) + (hra1 - hraDeduct) + special*12 + (lta - bill) - 50000;
                    if (gross <= 500000) {
                        float tax = 0;
                        t1.setText(String.valueOf(tax));
                    } else if (gross > 500000 && gross <= 1000000) {
                        float tax = (float) (0.2 * (gross - 500000) + 0.04 * 1000);
                        t1.setText(String.valueOf(tax));
                    } else if (gross > 1000000) {
                        float tax = (float) (100000 + (0.3 * (gross - 1000000)) + 0.04 * 2500);
                        t1.setText(String.valueOf(tax));
                    }

                }
            }
        });


    }
}