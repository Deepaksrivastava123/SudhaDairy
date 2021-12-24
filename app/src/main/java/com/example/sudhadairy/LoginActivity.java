package com.example.sudhadairy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.sudhadairy.Utils.SharedPrefUtils;
import com.example.sudhadairy.Utils.ValidationUtils;
import com.example.sudhadairy.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        handleClicks();
        SharedPrefUtils.getInstance(LoginActivity.this).saveAdminEmail("email","manish123@gmail.com");
        SharedPrefUtils.getInstance(LoginActivity.this).saveAdminPassword("password","manish@123");
    }

    private void initView() {

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    private void handleClicks(){
        binding.buttonLogin.setOnClickListener(view -> {
            validation();
        });
    }

    private void authenticateAdminAndLogin() {

        String email = SharedPrefUtils.getInstance(LoginActivity.this).getAdminEmail("email","");
        String password = SharedPrefUtils.getInstance(LoginActivity.this).getAdminPassword("password","");

        if (binding.editEmail.getText().toString().equals(email) && binding.editPassword.getText().toString().equals(password)){
            startActivity(new Intent(LoginActivity.this,HomeActivity.class));
         }
    }

    private void validation() {

        if (!ValidationUtils.blankValidation(binding.editEmail) ||
                !ValidationUtils.blankValidation(binding.editPassword)) {

            return;
        }
        authenticateAdminAndLogin();
    }
}