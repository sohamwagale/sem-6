package com.example.notesapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.notesapp.api.ApiClient;
import com.example.notesapp.api.NotesApi;
import com.example.notesapp.databinding.ActivityNoteDetailBinding;
import com.example.notesapp.models.DeleteResponse;
import com.example.notesapp.models.Note;
import com.example.notesapp.models.NoteRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Note detail screen. Shows a note's full content with timestamps.
 * Supports:
 *  - View mode (fields disabled)
 *  - Edit mode (toggle via pencil icon, fields become editable, save button appears)
 *  - Delete with confirmation dialog
 */
public class NoteDetailActivity extends AppCompatActivity {

    private ActivityNoteDetailBinding binding;
    private NotesApi notesApi;
    private int noteId;
    private boolean isEditing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNoteDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        notesApi = ApiClient.getNotesApi(this);
        noteId = getIntent().getIntExtra("note_id", -1);

        if (noteId == -1) {
            finish();
            return;
        }

        binding.ivBack.setOnClickListener(v -> finish());
        binding.ivEdit.setOnClickListener(v -> toggleEditMode());
        binding.ivDelete.setOnClickListener(v -> confirmDelete());
        binding.btnSave.setOnClickListener(v -> updateNote());

        loadNote();
    }

    private void loadNote() {
        binding.progressBar.setVisibility(View.VISIBLE);

        notesApi.getNote(noteId).enqueue(new Callback<Note>() {
            @Override
            public void onResponse(Call<Note> call, Response<Note> response) {
                binding.progressBar.setVisibility(View.GONE);
                if (response.isSuccessful() && response.body() != null) {
                    displayNote(response.body());
                } else {
                    Toast.makeText(NoteDetailActivity.this,
                        "Note not found", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

            @Override
            public void onFailure(Call<Note> call, Throwable t) {
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(NoteDetailActivity.this,
                    getString(R.string.error_network), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void displayNote(Note note) {
        binding.etTitle.setText(note.getTitle());
        binding.etBody.setText(note.getBody());
        binding.tvCreatedAt.setText(getString(R.string.label_created) + ": " + formatDate(note.getCreatedAt()));
        binding.tvUpdatedAt.setText(getString(R.string.label_updated) + ": " + formatDate(note.getUpdatedAt()));
    }

    private void toggleEditMode() {
        isEditing = !isEditing;
        binding.etTitle.setEnabled(isEditing);
        binding.etBody.setEnabled(isEditing);
        binding.btnSave.setVisibility(isEditing ? View.VISIBLE : View.GONE);

        if (isEditing) {
            binding.etTitle.requestFocus();
        }
    }

    private void updateNote() {
        String title = binding.etTitle.getText().toString().trim();
        String body = binding.etBody.getText().toString().trim();

        if (TextUtils.isEmpty(title)) {
            Toast.makeText(this, "Title is required", Toast.LENGTH_SHORT).show();
            return;
        }

        setLoading(true);

        NoteRequest request = new NoteRequest(title, body);
        notesApi.updateNote(noteId, request).enqueue(new Callback<Note>() {
            @Override
            public void onResponse(Call<Note> call, Response<Note> response) {
                setLoading(false);
                if (response.isSuccessful() && response.body() != null) {
                    Toast.makeText(NoteDetailActivity.this,
                        "Note updated!", Toast.LENGTH_SHORT).show();
                    isEditing = false;
                    binding.etTitle.setEnabled(false);
                    binding.etBody.setEnabled(false);
                    binding.btnSave.setVisibility(View.GONE);
                    displayNote(response.body());
                    setResult(RESULT_OK);
                } else {
                    Toast.makeText(NoteDetailActivity.this,
                        getString(R.string.error_generic), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Note> call, Throwable t) {
                setLoading(false);
                Toast.makeText(NoteDetailActivity.this,
                    getString(R.string.error_network), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void confirmDelete() {
        new AlertDialog.Builder(this)
            .setTitle("Delete Note")
            .setMessage("Are you sure you want to delete this note?")
            .setPositiveButton("Delete", (dialog, which) -> deleteNote())
            .setNegativeButton("Cancel", null)
            .show();
    }

    private void deleteNote() {
        setLoading(true);

        notesApi.deleteNote(noteId).enqueue(new Callback<DeleteResponse>() {
            @Override
            public void onResponse(Call<DeleteResponse> call, Response<DeleteResponse> response) {
                setLoading(false);
                if (response.isSuccessful()) {
                    Toast.makeText(NoteDetailActivity.this,
                        "Note deleted", Toast.LENGTH_SHORT).show();
                    setResult(RESULT_OK);
                    finish();
                } else {
                    Toast.makeText(NoteDetailActivity.this,
                        getString(R.string.error_generic), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DeleteResponse> call, Throwable t) {
                setLoading(false);
                Toast.makeText(NoteDetailActivity.this,
                    getString(R.string.error_network), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setLoading(boolean loading) {
        binding.progressBar.setVisibility(loading ? View.VISIBLE : View.GONE);
        binding.btnSave.setEnabled(!loading);
        binding.ivEdit.setEnabled(!loading);
        binding.ivDelete.setEnabled(!loading);
    }

    private String formatDate(String isoDate) {
        if (isoDate == null) return "";
        try {
            SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
            input.setTimeZone(TimeZone.getTimeZone("UTC"));
            String cleaned = isoDate;
            if (cleaned.contains("+")) {
                cleaned = cleaned.substring(0, cleaned.lastIndexOf('+'));
            } else if (cleaned.contains("Z")) {
                cleaned = cleaned.replace("Z", "");
            }
            Date date = input.parse(cleaned);
            SimpleDateFormat output = new SimpleDateFormat("MMM dd, yyyy 'at' hh:mm a", Locale.US);
            return date != null ? output.format(date) : isoDate;
        } catch (ParseException e) {
            return isoDate;
        }
    }
}
