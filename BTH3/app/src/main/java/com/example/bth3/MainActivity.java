package com.example.bth3;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    private List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        studentList = loadStudentsFromJSON();
        studentAdapter = new StudentAdapter(studentList, this);
        recyclerView.setAdapter(studentAdapter);
    }

    private List<Student> loadStudentsFromJSON() {
        List<Student> students = new ArrayList<>();
        try {
            InputStream is = getAssets().open("students.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            Gson gson = new Gson();
            Student[] studentArray = gson.fromJson(reader, Student[].class);
            students = Arrays.asList(studentArray);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}
