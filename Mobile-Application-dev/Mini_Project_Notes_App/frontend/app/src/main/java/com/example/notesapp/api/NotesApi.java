package com.example.notesapp.api;

import com.example.notesapp.models.DeleteResponse;
import com.example.notesapp.models.Note;
import com.example.notesapp.models.NoteRequest;
import com.example.notesapp.models.PaginatedNotes;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Retrofit interface for all notes CRUD endpoints.
 * All endpoints require Bearer token auth (handled by ApiClient interceptor).
 */
public interface NotesApi {

    @GET("/note/")
    Call<PaginatedNotes> getNotes(
        @Query("skip") int skip,
        @Query("limit") int limit,
        @Query("search") String search
    );

    @GET("/note/{note_id}")
    Call<Note> getNote(@Path("note_id") int noteId);

    @POST("/note/")
    Call<Note> createNote(@Body NoteRequest request);

    @PUT("/note/{note_id}")
    Call<Note> updateNote(@Path("note_id") int noteId, @Body NoteRequest request);

    @DELETE("/note/{note_id}")
    Call<DeleteResponse> deleteNote(@Path("note_id") int noteId);
}
