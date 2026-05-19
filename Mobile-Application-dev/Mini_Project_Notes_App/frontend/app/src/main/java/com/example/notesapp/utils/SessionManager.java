package com.example.notesapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Manages JWT session tokens and user info using SharedPreferences.
 * Provides save/get/clear operations for authentication state.
 */
public class SessionManager {
    private static final String PREF_NAME = "NotesAppSession";
    private static final String KEY_TOKEN = "auth_token";
    private static final String KEY_EMAIL = "user_email";

    private final SharedPreferences prefs;

    public SessionManager(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void saveToken(String token) {
        prefs.edit().putString(KEY_TOKEN, token).apply();
    }

    public String getToken() {
        return prefs.getString(KEY_TOKEN, null);
    }

    public void saveEmail(String email) {
        prefs.edit().putString(KEY_EMAIL, email).apply();
    }

    public String getEmail() {
        return prefs.getString(KEY_EMAIL, null);
    }

    public boolean isLoggedIn() {
        return getToken() != null;
    }

    public void clear() {
        prefs.edit().clear().apply();
    }
}
