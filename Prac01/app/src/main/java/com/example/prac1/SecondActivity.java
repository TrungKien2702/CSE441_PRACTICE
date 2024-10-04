package com.example.prac1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private EditText edtName, edtGpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        edtName = findViewById(R.id.edtName);
        edtGpa = findViewById(R.id.edtGpa);
        Button submitButton = findViewById(R.id.btnSubmit);

        submitButton.setOnClickListener(v -> {
            String name = edtName.getText().toString();
            String gpa = edtGpa.getText().toString();

            Intent resultIntent = new Intent();
            resultIntent.putExtra("name", name);
            resultIntent.putExtra("gpa", gpa);

            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
