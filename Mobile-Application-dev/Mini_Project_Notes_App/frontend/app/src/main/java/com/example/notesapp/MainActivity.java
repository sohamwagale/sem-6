package com.example.notesapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.notesapp.adapters.NotesAdapter;
import com.example.notesapp.api.ApiClient;
import com.example.notesapp.api.NotesApi;
import com.example.notesapp.databinding.ActivityMainBinding;
import com.example.notesapp.models.DeleteResponse;
import com.example.notesapp.models.Note;
import com.example.notesapp.models.PaginatedNotes;
import com.example.notesapp.utils.NotesItemDecoration;
import com.example.notesapp.utils.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Main screen — displays the user's notes in a RecyclerView.
 * Features: search, pull-to-refresh, pagination, FAB to add, logout.
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private NotesAdapter adapter;
    private NotesApi notesApi;
    private SessionManager session;

    private final Handler searchHandler = new Handler(Looper.getMainLooper());
    private Runnable searchRunnable;
    private String currentSearch = null;

    // Launcher for AddNote / NoteDetail that triggers a refresh on return
    private final ActivityResultLauncher<Intent> noteLauncher =
        registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            loadNotes();
        });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        session = new SessionManager(this);
        notesApi = ApiClient.getNotesApi(this);

        setupRecyclerView();
        setupSearch();
        setupListeners();
        loadNotes();
    }

    private void setupRecyclerView() {
        adapter = new NotesAdapter();
        adapter.setOnNoteClickListener(note -> {
            Intent intent = new Intent(this, NoteDetailActivity.class);
            intent.putExtra("note_id", note.getNoteId());
            noteLauncher.launch(intent);
        });

        binding.rvNotes.setLayoutManager(new LinearLayoutManager(this));
        binding.rvNotes.setAdapter(adapter);
        binding.rvNotes.addItemDecoration(new NotesItemDecoration(
            getResources().getDimensionPixelSize(R.dimen.spacing_sm)
        ));
    }

    private void setupSearch() {
        binding.etSearch.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                if (searchRunnable != null) searchHandler.removeCallbacks(searchRunnable);
                searchRunnable = () -> {
                    String query = s.toString().trim();
                    currentSearch = query.isEmpty() ? null : query;
                    loadNotes();
                };
                searchHandler.postDelayed(searchRunnable, 400); // Debounce 400ms
            }
        });
    }

    private void setupListeners() {
        binding.fabAdd.setOnClickListener(v -> {
            noteLauncher.launch(new Intent(this, AddNoteActivity.class));
        });

        binding.ivLogout.setOnClickListener(v -> {
            session.clear();
            ApiClient.reset();
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

        binding.swipeRefresh.setColorSchemeColors(getColor(R.color.amber_primary));
        binding.swipeRefresh.setProgressBackgroundColorSchemeColor(getColor(R.color.surface_elevated));
        binding.swipeRefresh.setOnRefreshListener(this::loadNotes);
    }

    private void loadNotes() {
        binding.progressBar.setVisibility(View.VISIBLE);
        binding.layoutEmpty.setVisibility(View.GONE);

        notesApi.getNotes(0, 50, currentSearch).enqueue(new Callback<PaginatedNotes>() {
            @Override
            public void onResponse(Call<PaginatedNotes> call, Response<PaginatedNotes> response) {
                binding.progressBar.setVisibility(View.GONE);
                binding.swipeRefresh.setRefreshing(false);

                if (response.isSuccessful() && response.body() != null) {
                    PaginatedNotes data = response.body();
                    adapter.setNotes(data.getItems());
                    binding.layoutEmpty.setVisibility(
                        data.getItems().isEmpty() ? View.VISIBLE : View.GONE
                    );
                    binding.rvNotes.setVisibility(
                        data.getItems().isEmpty() ? View.GONE : View.VISIBLE
                    );
                } else if (response.code() == 401) {
                    // Token expired — force re-login
                    session.clear();
                    ApiClient.reset();
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                } else {
                    Toast.makeText(MainActivity.this,
                        getString(R.string.error_generic), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PaginatedNotes> call, Throwable t) {
                binding.progressBar.setVisibility(View.GONE);
                binding.swipeRefresh.setRefreshing(false);
                Toast.makeText(MainActivity.this,
                    getString(R.string.error_network), Toast.LENGTH_SHORT).show();
            }
        });
    }
}