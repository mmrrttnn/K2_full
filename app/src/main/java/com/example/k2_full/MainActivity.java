package com.example.k2_full;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ClothingAdapter clothingAdapter;
    private List<Clothing> clothingList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        clothingList = generateClothingItems();

        clothingAdapter = new ClothingAdapter(getSupportFragmentManager(), clothingList);
        recyclerView.setAdapter(clothingAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private ArrayList<Clothing> generateClothingItems() {
        ArrayList<Clothing> clothingArrayList = new ArrayList<>();
        clothingArrayList.add(new Clothing("Shirt", 25.00, 20, "China"));
        clothingArrayList.add(new Clothing("Trousers", 30.00, 5, "Vietnam"));
        clothingArrayList.add(new Clothing("T-Shirt", 5.00, 40, "Taiwan"));
        clothingArrayList.add(new Clothing("Shoes", 10.00, 80, "Taiwan"));
        clothingArrayList.add(new Clothing("Hat", 15.00, 15, "China"));
        clothingArrayList.add(new Clothing("Shorts", 35.00, 10, "Vietnam"));

        return clothingArrayList;
    }
}