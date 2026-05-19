package com.example.notesapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.notesapp.api.ApiClient;
import com.example.notesapp.databinding.ActivityRegisterBinding;
import com.example.notesapp.models.RegisterRequest;
import com.example.notesapp.models.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Registration screen. Creates a new user account via POST /user/.
 * On success, navigates back to LoginActivity for authentication.
 */
public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ivBack.setOnClickListener(v -> finish());
        binding.btnRegister.setOnClickListener(v -> attemptRegister());
        binding.tvLoginLink.setOnClickListener(v -> finish());
    }

    private void attemptRegister() {
        String name = binding.etName.getText().toString().trim();
        String email = binding.etEmail.getText().toString().trim();
        String password = binding.etPassword.getText().toString().trim();
        String confirmPassword = binding.etConfirmPassword.getText().toString().trim();

        // Validate
        if (TextUtils.isEmpty(name)) {
            showError(getString(R.string.register_error_name));
            return;
        }
        if (TextUtils.isEmpty(email)) {
            showError(getString(R.string.login_error_email));
            return;
        }
        if (TextUtils.isEmpty(password)) {
            showError(getString(R.string.login_error_password));
            return;
        }
        if (!password.equals(confirmPassword)) {
            showError(getString(R.string.register_error_passwords));
            return;
        }

        setLoading(true);

        RegisterRequest request = new RegisterRequest(name, email, password);
        ApiClient.getAuthApi(this).register(request).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                setLoading(false);
                if (response.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this,
                        "Account created! Please sign in.", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    showError("Registration failed. Email may already be in use.");
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                setLoading(false);
                showError(getString(R.string.error_network));
            }
        });
    }

    private void setLoading(boolean loading) {
        binding.progressBar.setVisibility(loading ? View.VISIBLE : View.GONE);
        binding.btnRegister.setVisibility(loading ? View.GONE : View.VISIBLE);
        binding.etName.setEnabled(!loading);
        binding.etEmail.setEnabled(!loading);
        binding.etPassword.setEnabled(!loading);
        binding.etConfirmPassword.setEnabled(!loading);
    }

    private void showError(String message) {
        binding.tvError.setText(message);
        binding.tvError.setVisibility(View.VISIBLE);
    }
}
