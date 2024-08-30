package com.example.myproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {
    private WordDatabaseHelper dbHelper;
    private SimpleCursorAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        Button button=findViewById(R.id.backfromlist);
        ListView listView = findViewById(R.id.wordListView);
        dbHelper = new WordDatabaseHelper(this);

        displayWords(listView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity4.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void displayWords(ListView listView) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                WordDatabaseHelper.COLUMN_ID,
                WordDatabaseHelper.COLUMN_WORD,
                WordDatabaseHelper.COLUMN_DESCRIPTION
        };

        Cursor cursor = db.query(
                WordDatabaseHelper.TABLE_WORDS,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        String[] fromColumns = {
                WordDatabaseHelper.COLUMN_WORD,
                WordDatabaseHelper.COLUMN_DESCRIPTION
        };

        int[] toViews = {
                R.id.wordTextView,
                R.id.descriptionTextView
        };

        adapter = new SimpleCursorAdapter(
                this,
                R.layout.list_item,
                cursor,
                fromColumns,
                toViews,
                0
        );

        listView.setAdapter(adapter);
    }
}