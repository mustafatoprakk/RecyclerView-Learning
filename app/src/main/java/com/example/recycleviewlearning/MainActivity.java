package com.example.recycleviewlearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> courseName = new ArrayList<>();
    ArrayList<String> courseExplanation = new ArrayList<>();
    ArrayList<Integer> pictures = new ArrayList<>();

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);

        courseName.add("Chrome");
        courseName.add("Spotify");
        courseName.add("Cloud");

        courseExplanation.add("This is course is about Chrome");
        courseExplanation.add("This is course is about Spotify");
        courseExplanation.add("This is course is about Cloud");

        pictures.add(R.drawable.chrome1);
        pictures.add(R.drawable.spotify);
        pictures.add(R.drawable.soundcloud);


        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(courseName, courseExplanation, pictures, this);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}