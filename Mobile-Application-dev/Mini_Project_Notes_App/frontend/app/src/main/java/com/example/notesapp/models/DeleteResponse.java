package com.example.notesapp.models;

import com.google.gson.annotations.SerializedName;

public class DeleteResponse {
    @SerializedName("message")
    private String message;

    public String getMessage() { return message; }
}
