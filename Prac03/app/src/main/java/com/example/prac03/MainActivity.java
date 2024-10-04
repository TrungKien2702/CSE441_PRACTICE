package com.example.prac03;


import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CountryAdapter countryAdapter;
    List<Country> countryList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.recyclerView), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        countryList = new ArrayList<>();
        countryList.add(new Country("India", "New Delhi", "1.428 billion", "2,973,190 Km²", R.drawable.india_flag));
        countryList.add(new Country("China", "Beijing", "1.412 billion", "9,596,961 Km²", R.drawable.china_flag));
        countryList.add(new Country("United States", "Washington DC", "339.6 million", "9,833,517 Km²", R.drawable.us_flag));
        countryList.add(new Country("Indonesia", "Jakarta", "277.5 million", "1,904,569 Km²", R.drawable.indo_flag));
        countryList.add(new Country("Pakistan", "Islamabad", "240.5 million", "881,913 Km²", R.drawable.pakistan_flag));
        countryList.add(new Country("Nigeria", "Abuja", "223.8 million", "923,768 Km²", R.drawable.nigeria_flag));
        countryList.add(new Country("Brazil", "Brasilia", "216.4 million", "8,515,767 Km²", R.drawable.brazil_flag));
        countryList.add(new Country("Bangladesh", "Dhaka", "173.2 million", "148,460 Km²", R.drawable.bangladesh_flag));

        countryAdapter = new CountryAdapter(this, countryList);
        recyclerView.setAdapter(countryAdapter);
        };
}

