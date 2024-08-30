package com.example.myproject;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {
    private EditText wordEditText;
    private EditText descriptionEditText;
    private WordDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        wordEditText = findViewById(R.id.wordEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        Button addButton = findViewById(R.id.addButton);

        dbHelper = new WordDatabaseHelper(this);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addWordToDatabase();
            }
        });
    }
    private void addWordToDatabase() {
        String word = wordEditText.getText().toString().trim();
        String description = descriptionEditText.getText().toString().trim();

        if (word.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, "Please fill out both fields", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(WordDatabaseHelper.COLUMN_WORD, word);
        values.put(WordDatabaseHelper.COLUMN_DESCRIPTION, description);

        long newRowId = db.insert(WordDatabaseHelper.TABLE_WORDS, null, values);

        if (newRowId == -1) {
            Toast.makeText(this, "Error saving word", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Word added", Toast.LENGTH_SHORT).show();
            wordEditText.setText("");
            descriptionEditText.setText("");

            Intent intent = new Intent(MainActivity3.this,MainActivity4.class);
            startActivity(intent);
        }
    }
}