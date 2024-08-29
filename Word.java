package com.example.myproject;

public class Word {
    private long id;
    private String word;
    private String description;

    public Word() { }

    public Word(String word, String description) {
        this.word = word;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
