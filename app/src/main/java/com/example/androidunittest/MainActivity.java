package com.example.androidunittest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidunittest.R;

public class MainActivity extends AppCompatActivity {

    private EditText etWeight, etHeight;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    public double calculateBMI(double weight, double height) {
        if (weight <= 0 || height <= 0) {
            return -1; // Data tidak valid
        }
        return weight / (height * height);
    }

    private void calculateBMI() {
        String weightStr = etWeight.getText().toString();
        String heightStr = etHeight.getText().toString();

        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            tvResult.setText("Masukkan berat dan tinggi yang valid");
            return;
        }

        double weight = Double.parseDouble(weightStr);
        double height = Double.parseDouble(heightStr) / 100; // konversi ke meter

        double bmi = calculateBMI(weight, height);
        if (bmi == -1) {
            tvResult.setText("Data tidak valid");
        } else {
            // Ambil kategori BMI dari BMICategory
            String category = new BMICategory().getBMICategory(bmi);
            // Tampilkan nilai BMI dan kategori
            tvResult.setText(String.format("BMI Anda: %.2f (%s)", bmi, category));
        }
    }
}