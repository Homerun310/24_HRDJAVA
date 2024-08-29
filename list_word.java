package com.example.myproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class list_word extends AppCompatActivity {

    private RecyclerView rv;
    private WordAdapter adapter;
    private List<Word> wordList;
    private WordDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.word_list);

        rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));

        dataSource = new WordDataSource(this);
        dataSource.open();

        // 데이터베이스에서 모든 단어 가져오기
        List<Word> words = dataSource.getAllWords();

        // 어댑터 초기화 및 RecyclerView 설정
        adapter = new WordAdapter(words);
        rv.setAdapter(adapter);


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        dataSource.close();
    }



}