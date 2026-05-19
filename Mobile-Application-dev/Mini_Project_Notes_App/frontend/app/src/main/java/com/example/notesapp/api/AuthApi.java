package com.example.notesapp.api;

import com.example.notesapp.models.RegisterRequest;
import com.example.notesapp.models.TokenResponse;
import com.example.notesapp.models.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Retrofit interface for authentication and user endpoints.
 * Login uses form-urlencoded (OAuth2PasswordRequestForm),
 * registration uses JSON body.
 */
public interface AuthApi {

    @FormUrlEncoded
    @POST("/login")
    Call<TokenResponse> login(
        @Field("username") String email,
        @Field("password") String password
    );

    @POST("/user/")
    Call<UserResponse> register(@Body RegisterRequest request);
}
