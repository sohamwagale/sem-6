package com.example.notesapp.api;

import android.content.Context;

import com.example.notesapp.utils.SessionManager;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit singleton client configured with:
 * - Base URL pointing to backend (10.0.2.2 for Android emulator → host localhost)
 * - Auth interceptor that injects Bearer token from SessionManager
 * - HTTP logging for debug builds
 */
public class ApiClient {
    // Ngrok static domain tunneling to your PC
    private static final String BASE_URL = "https://straked-noncadent-clifton.ngrok-free.dev";

    private static Retrofit retrofit = null;

    public static Retrofit getClient(Context context) {
        if (retrofit == null) {
            SessionManager session = new SessionManager(context.getApplicationContext());

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request.Builder builder = chain.request().newBuilder();
                    String token = session.getToken();
                    if (token != null) {
                        builder.addHeader("Authorization", "Bearer " + token);
                    }
                    return chain.proceed(builder.build());
                })
                .addInterceptor(logging)
                .build();

            retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        }
        return retrofit;
    }

    public static AuthApi getAuthApi(Context context) {
        return getClient(context).create(AuthApi.class);
    }

    public static NotesApi getNotesApi(Context context) {
        return getClient(context).create(NotesApi.class);
    }

    /** Force re-creation of Retrofit instance (call after login/logout) */
    public static void reset() {
        retrofit = null;
    }
}
