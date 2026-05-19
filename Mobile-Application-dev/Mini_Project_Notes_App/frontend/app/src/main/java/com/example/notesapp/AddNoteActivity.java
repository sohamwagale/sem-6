package com.example.notesapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.notesapp.api.ApiClient;
import com.example.notesapp.api.NotesApi;
import com.example.notesapp.databinding.ActivityAddNoteBinding;
import com.example.notesapp.models.Note;
import com.example.notesapp.models.NoteRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Screen for creating a new note.
 * Sends POST /note/ with title and body, then finishes to return to the list.
 */
public class AddNoteActivity extends AppCompatActivity {

    private ActivityAddNoteBinding binding;
    private NotesApi notesApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddNoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        notesApi = ApiClient.getNotesApi(this);

        binding.ivBack.setOnClickListener(v -> finish());
        binding.btnSave.setOnClickListener(v -> saveNote());
    }

    private void saveNote() {
        String title = binding.etTitle.getText().toString().trim();
        String body = binding.etBody.getText().toString().trim();

        if (TextUtils.isEmpty(title)) {
            Toast.makeText(this, "Title is required", Toast.LENGTH_SHORT).show();
            return;
        }

        setLoading(true);

        NoteRequest request = new NoteRequest(title, body);
        notesApi.createNote(request).enqueue(new Callback<Note>() {
            @Override
            public void onResponse(Call<Note> call, Response<Note> response) {
                setLoading(false);
                if (response.isSuccessful()) {
                    Toast.makeText(AddNoteActivity.this,
                        "Note created!", Toast.LENGTH_SHORT).show();
                    setResult(RESULT_OK);
                    finish();
                } else {
                    Toast.makeText(AddNoteActivity.this,
                        getString(R.string.error_generic), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Note> call, Throwable t) {
                setLoading(false);
                Toast.makeText(AddNoteActivity.this,
                    getString(R.string.error_network), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setLoading(boolean loading) {
        binding.progressBar.setVisibility(loading ? View.VISIBLE : View.GONE);
        binding.btnSave.setVisibility(loading ? View.GONE : View.VISIBLE);
        binding.etTitle.setEnabled(!loading);
        binding.etBody.setEnabled(!loading);
    }
}
