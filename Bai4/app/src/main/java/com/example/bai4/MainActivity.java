package com.example.bai4;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText etName, etHeight, etWeight;
    private Button btnCalculate;
    private TextView tvBmi, tvDiagnosis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        etHeight = findViewById(R.id.et_height);
        etWeight = findViewById(R.id.et_weight);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvBmi = findViewById(R.id.tv_bmi);
        tvDiagnosis = findViewById(R.id.tv_diagnosis);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String heightStr = etHeight.getText().toString();
        String weightStr = etWeight.getText().toString();

        if (!heightStr.isEmpty() && !weightStr.isEmpty()) {
            float height = Float.parseFloat(heightStr);
            float weight = Float.parseFloat(weightStr);

            float bmi = weight / (height * height);
            tvBmi.setText("BMI = " + String.format("%.2f", bmi));

            String diagnosis;
            if (bmi < 18) {
                diagnosis = "Người gầy";
            } else if (bmi >= 18 && bmi < 24.9) {
                diagnosis = "Người bình thường";
            } else if (bmi >= 25 && bmi < 29.9) {
                diagnosis = "Thừa cân";
            } else {
                diagnosis = "Béo phì";
            }
            tvDiagnosis.setText("Chuẩn đoán: " + diagnosis);
        }
    }
}
