package com.example.notesapp.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesapp.databinding.ItemNoteBinding;
import com.example.notesapp.models.Note;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/**
 * RecyclerView adapter for displaying note cards.
 * Handles date formatting, body preview truncation, and click events.
 */
public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {

    private List<Note> notes = new ArrayList<>();
    private OnNoteClickListener listener;

    public interface OnNoteClickListener {
        void onNoteClick(Note note);
    }

    public void setOnNoteClickListener(OnNoteClickListener listener) {
        this.listener = listener;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    public Note getNoteAt(int position) {
        return notes.get(position);
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNoteBinding binding = ItemNoteBinding.inflate(
            LayoutInflater.from(parent.getContext()), parent, false
        );
        return new NoteViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.bind(note);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {
        private final ItemNoteBinding binding;

        NoteViewHolder(ItemNoteBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            itemView.setOnClickListener(v -> {
                int pos = getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION && listener != null) {
                    listener.onNoteClick(notes.get(pos));
                }
            });
        }

        void bind(Note note) {
            binding.tvTitle.setText(note.getTitle());
            binding.tvBody.setText(note.getBody());
            binding.tvDate.setText(formatDate(note.getUpdatedAt()));
        }
    }

    /** Parses ISO 8601 date from the backend and formats it as "MMM dd, yyyy" */
    private String formatDate(String isoDate) {
        if (isoDate == null) return "";
        try {
            // Backend returns ISO format like "2026-04-26T12:30:00+00:00"
            SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
            input.setTimeZone(TimeZone.getTimeZone("UTC"));
            // Strip timezone info if present for simpler parsing
            String cleaned = isoDate;
            if (cleaned.contains("+")) {
                cleaned = cleaned.substring(0, cleaned.lastIndexOf('+'));
            } else if (cleaned.contains("Z")) {
                cleaned = cleaned.replace("Z", "");
            }
            Date date = input.parse(cleaned);
            SimpleDateFormat output = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
            return date != null ? output.format(date) : isoDate;
        } catch (ParseException e) {
            return isoDate;
        }
    }
}
