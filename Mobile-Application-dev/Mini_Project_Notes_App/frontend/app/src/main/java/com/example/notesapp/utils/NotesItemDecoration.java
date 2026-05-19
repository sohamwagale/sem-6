package com.example.notesapp.utils;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Adds vertical spacing between RecyclerView items.
 */
public class NotesItemDecoration extends RecyclerView.ItemDecoration {
    private final int spacing;

    public NotesItemDecoration(int spacing) {
        this.spacing = spacing;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view,
                               @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.bottom = spacing;
    }
}
