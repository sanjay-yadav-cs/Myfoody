package com.example.myfoody;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myfoody.databinding.ActivityLoginBinding;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    ProgressDialog progressDialog;
    private AppBarConfiguration appBarConfiguration;
    private ActivityLoginBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth=FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setTitle("SigIn");
        progressDialog.setMessage("Please wait..");

        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(binding.etloginEmail.getText().toString()) || (TextUtils.isEmpty(binding.etloginPassword.getText().toString()))) {
                    if (TextUtils.isEmpty(binding.etloginEmail.getText().toString())) {
                        binding.etloginEmail.setError("Enter Email");
                    } else {
                        binding.etloginPassword.setError("Enter Password");
                    }
                } else {
                    progressDialog.show();
                    auth.signInWithEmailAndPassword(binding.etloginEmail.getText().toString(), binding.etloginPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(LoginActivity.this, Food_catlog.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }

                    });
                }
            }
            });

                binding.tvCreateAccount.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(LoginActivity.this, signUp.class);
                        startActivity(intent);
                        finish();
                    }
                });

        if(auth.getCurrentUser()!=null){
            Intent intent=new Intent(LoginActivity.this,Food_catlog.class);
            startActivity(intent);
            finish();
        }


            }
        }