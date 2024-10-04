package com.example.prac03;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    ImageView flagImageView;
    TextView txtCountryName, txtCapital, txtPopulation, txtArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        flagImageView = findViewById(R.id.flagImageView);
        txtCountryName = findViewById(R.id.txtCountryName);
        txtCapital = findViewById(R.id.txtCapital);
        txtPopulation = findViewById(R.id.txtPopulation);
        txtArea = findViewById(R.id.txtArea);

        String countryName = getIntent().getStringExtra("countryName");
        String capital = getIntent().getStringExtra("capital");
        String population = getIntent().getStringExtra("population");
        String area = getIntent().getStringExtra("area");
        int flag = getIntent().getIntExtra("flag", 0);

        txtCountryName.setText(countryName);
        txtCapital.setText("Capital: " + capital);
        txtPopulation.setText("Population: " + population);
        txtArea.setText("Area: " + area);
        flagImageView.setImageResource(flag);
    }
}

