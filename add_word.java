package com.example.myproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class add_word extends AppCompatActivity {
    Button button;
    EditText editText1, editText2;
    private WordDataSource dataSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.add_word);

        button = findViewById(R.id.addword);
        editText1 = findViewById(R.id.wordEditText);
        editText2 = findViewById(R.id.descriptionEditText);

        dataSource = new WordDataSource(this);
        dataSource.open();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = editText1.getText().toString();
                String description = editText2.getText().toString();

                if (!word.isEmpty() && !description.isEmpty()) {
                    dataSource.createWord(word, description);
                    Intent intent = new Intent(add_word.this, list_word.class);

                    startActivity(intent);
                } else {
                    editText1.setError("Please enter a word");
                    editText2.setError("Please enter a description");
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dataSource.close();
    }
}