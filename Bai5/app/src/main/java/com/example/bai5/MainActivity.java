package com.example.bai5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editGregorianYear;
    private TextView tvLunarYear;
    private Button btnConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editGregorianYear = findViewById(R.id.edit_gregorian_year);
        tvLunarYear = findViewById(R.id.tv_lunar_year);
        btnConvert = findViewById(R.id.btn_convert);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertYear();
            }
        });
    }

    private void convertYear() {
        String gregorianYearStr = editGregorianYear.getText().toString();

        if (!gregorianYearStr.isEmpty()) {
            int gregorianYear = Integer.parseInt(gregorianYearStr);
            String lunarYear = getLunarYear(gregorianYear);
            tvLunarYear.setText(lunarYear);
        } else {
            tvLunarYear.setText("Vui lòng nhập năm dương lịch");
        }
    }


    private String getLunarYear(int year) {
        String[] can = {"Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỳ"};
        String[] chi = {"Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi" };

        int canIndex = year % 10;
        int chiIndex = year % 12;

        return can[canIndex] + " " + chi[chiIndex];
    }
}
