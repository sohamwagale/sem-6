package com.example.notesapp.models;

import com.google.gson.annotations.SerializedName;

public class NoteRequest {
    @SerializedName("title")
    private String title;

    @SerializedName("body")
    private String body;

    public NoteRequest(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() { return title; }
    public String getBody() { return body; }
}
