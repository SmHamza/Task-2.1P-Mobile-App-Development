package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    EditText value;
    TextView result1, result2,result3;
    ImageButton imageButton1, imageButton2, imageButton3;
    float input, num1, num2, num3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner_id);
        value = findViewById(R.id.value);
        result1 = findViewById(R.id.result1);
        result2 = findViewById(R.id.result2);
        result3 = findViewById((R.id.result3));
        imageButton1 = findViewById(R.id.button1);
        imageButton2 = findViewById(R.id.button2);
        imageButton3 = findViewById(R.id.button3);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.measurements, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (spinner.getSelectedItemPosition() == 0)
                {
                    input = Float.parseFloat(value.getText().toString());

                    num1 = 100*input;
                    num2 = (float) ((3.28084)*input);
                    num3 = (float) ((39.3701)*input);

                    result1.setText( (String.format("%.2f", num1))+ " Centimetre");
                    result2.setText( (String.format("%.2f", num2))+ " Foot");
                    result3.setText( (String.format("%.2f", num3))+ " Inch");
                }
                else
                {
                    result1.setText("");
                    result2.setText("");
                    result3.setText("");
                    Toast.makeText( MainActivity.this ,  "Please select the correct conversion icon",Toast.LENGTH_LONG).show();
                }
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (spinner.getSelectedItemPosition() == 1)
                {
                    input = Float.parseFloat(value.getText().toString());
                    num1 = (float)(9*input)/5 +32;
                    num2 = (float)(input + 273.151);

                    result1.setText( (String.format("%.2f", num1))+ " Fahrenheit");
                    result2.setText( (String.format("%.2f", num2))+ " Kelvin");
                    result3.setText("");
                }
                else
                {
                    result1.setText("");
                    result2.setText("");
                    result3.setText("");
                    Toast.makeText( MainActivity.this ,  "Please select the correct conversion icon",Toast.LENGTH_LONG).show();
                }
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (spinner.getSelectedItemPosition() == 2)
                {
                    input = Float.parseFloat(value.getText().toString());
                    num1 = (float)(9*input)/5 +32;
                    num2 = (float)(input + 273.151);

                    num1 = 1000*input;
                    num2 = (float) ((35.274)*input);
                    num3 = (float) ((2.205)*input);

                    result1.setText( (String.format("%.2f", num1)) + " Grams");
                    result2.setText( (String.format("%.2f", num2)) + " Ounces(Oz)");
                    result3.setText( (String.format("%.2f", num3)) + " Pound(lb)");
                }
                else
                {
                    result1.setText("");
                    result2.setText("");
                    result3.setText("");
                    Toast.makeText( MainActivity.this ,  "Please select the correct conversion icon",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}