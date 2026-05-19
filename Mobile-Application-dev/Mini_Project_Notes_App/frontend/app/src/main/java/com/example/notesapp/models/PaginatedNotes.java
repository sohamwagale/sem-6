package com.example.notesapp.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PaginatedNotes {
    @SerializedName("total")
    private int total;

    @SerializedName("items")
    private List<Note> items;

    public int getTotal() { return total; }
    public List<Note> getItems() { return items; }
}
