package com.husyairi.valuecomparison;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Calculate extends AppCompatActivity {

    EditText quantityA, volumeA, priceA, quantityB, volumeB, priceB;

    TextView resultA, resultB, suggestion, difference;

    RelativeLayout layoutA, layoutB, layoutResultA, layoutResultB;

    Button calculateBtn, resetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        getSupportActionBar().hide();

        layoutA = findViewById(R.id.productA_layout);
        layoutB = findViewById(R.id.productB_layout);
        layoutResultA = findViewById(R.id.resultA_layout);
        layoutResultB = findViewById(R.id.resultB_layout);

        quantityA = findViewById(R.id.quantityA);
        volumeA = findViewById(R.id.volumeA);
        priceA = findViewById(R.id.priceA);
        resultA = findViewById(R.id.resultA);

        quantityB = findViewById(R.id.quantityB);
        volumeB = findViewById(R.id.volumeB);
        priceB = findViewById(R.id.priceB);
        resultB = findViewById(R.id.resultB);

        suggestion = findViewById(R.id.suggestion);
        difference = findViewById(R.id.difference);
        calculateBtn = findViewById(R.id.calculateButton);

        // Feature : add weighted score (the quality, ketahanan, how much you like, is it worth the 1 ringgit difference?)

        // TODO: more details
        //          - to 3 decimal points
        //          - add colours to the ones that is more berbaloi

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    String valuequantityA = quantityA.getText().toString();
                    double qttA = Double.parseDouble(valuequantityA);

                    String valuevolumeA = volumeA.getText().toString();
                    double volA = Double.parseDouble(valuevolumeA);

                    String valuepriceA = priceA.getText().toString();
                    double prcA = Double.parseDouble(valuepriceA);

                    String valuequantityB = quantityB.getText().toString();
                    double qttB = Double.parseDouble(valuequantityB);

                    String valuevolumeB = volumeB.getText().toString();
                    double volB = Double.parseDouble(valuevolumeB);

                    String valuepriceB = priceB.getText().toString();
                    double prcB = Double.parseDouble(valuepriceB);

                    double valueA = prcA / (qttA * volA);
                    double valueB = prcB / (qttB * volB);

                    String formattedValueA = String.format("%.2f", valueA); // Limit to 2 decimal places
                    resultA.setText(String.valueOf(formattedValueA));

                    String formattedValueB = String.format("%.2f", valueB); // Limit to 2 decimal places
                    resultB.setText(String.valueOf(formattedValueB));

                    double dif = 0;

                    // Compare valueA and valueB
                    if (valueA < valueB) {
                        suggestion.setText(R.string.berbaloi_a);
                        dif = valueB - valueA;
                        //layoutA.setBackgroundColor(Color.parseColor("#00CF00"));
                        //layoutResultA.setBackgroundColor(Color.parseColor("#00CF00"));


                    } else if (valueA > valueB) {
                        suggestion.setText(R.string.berbaloi_b);
                        dif = valueA - valueB;

                    } else {
                        suggestion.setText("Both are equally berbaloi");
                    }
                    String formattedDifference = String.format("%.2f", dif); // Limit to 2 decimal places
                    difference.setText(String.valueOf(formattedDifference));

                }catch (NumberFormatException e){
                    Log.e("Calculate", "Invalid input: " + e.getMessage());
                    suggestion.setText("Please enter valid numbers");
                }

            }
        });

        resetBtn = findViewById(R.id.resetButton);

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantityA.setText(null);
                volumeA.setText(null);
                priceA.setText(null);
                resultA.setText(null);
                quantityB.setText(null);
                volumeB.setText(null);
                priceB.setText(null);
                resultB.setText(null);
                difference.setText(null);
                suggestion.setText(null);

            }
        });


    }
}