package com.example.myproject;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
public class WordDataSource {
    private SQLiteDatabase database;
    private MyDatabaseHelper dbHelper;

    private String[] allColumns = { MyDatabaseHelper.COLUMN_ID,
            MyDatabaseHelper.COLUMN_WORD,
            MyDatabaseHelper.COLUMN_DESCRIPTION };

    public WordDataSource(Context context) {
        dbHelper = new MyDatabaseHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Word createWord(String word, String description) {
        ContentValues values = new ContentValues();
        values.put(MyDatabaseHelper.COLUMN_WORD, word);
        values.put(MyDatabaseHelper.COLUMN_DESCRIPTION, description);
        long insertId = database.insert(MyDatabaseHelper.TABLE_WORDS, null, values);
        Cursor cursor = database.query(MyDatabaseHelper.TABLE_WORDS,
                allColumns, MyDatabaseHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Word newWord = cursorToWord(cursor);
        cursor.close();
        return newWord;
    }

    public List<Word> getAllWords() {
        List<Word> words = new ArrayList<>();
        Cursor cursor = database.query(MyDatabaseHelper.TABLE_WORDS,
                allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Word word = cursorToWord(cursor);
            words.add(word);
            cursor.moveToNext();
        }
        cursor.close();
        return words;
    }

    private Word cursorToWord(Cursor cursor) {
        Word word = new Word();
        word.setId(cursor.getLong(0));
        word.setWord(cursor.getString(1));
        word.setDescription(cursor.getString(2));
        return word;
    }
}
