package com.example.myfoody;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myfoody.Models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class signUp extends AppCompatActivity {
Button register;
TextView tvlogin;
EditText etEmail,etPassword,etUserName,etPhone;
private FirebaseAuth auth;
FirebaseDatabase database;
ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().setTitle("SignUp");

        progressDialog = new ProgressDialog(signUp.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("We Are Creating Your Account");

        auth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();


        tvlogin=findViewById(R.id.tvLogin);
        register=findViewById(R.id.register);
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        etUserName=findViewById(R.id.etUserName);
        etPhone=findViewById(R.id.etPhone);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(etEmail.getText().toString()) || (TextUtils.isEmpty(etPassword.getText().toString()))){
                    if(TextUtils.isEmpty(etEmail.getText().toString())){
                        etEmail.setError("Enter Email");
                    }
                    else {
                        etPassword.setError("Enter Password");
                    }
                }
                else {
                    progressDialog.show();
                    auth.createUserWithEmailAndPassword(etEmail.getText().toString(),etPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if(task.isSuccessful()){
                                User user=new User(etUserName.getText().toString(),etPassword.getText().toString(),
                                        etEmail.getText().toString(),etPhone.getText().toString());
                                String id=task.getResult().getUser().getUid();
                                database.getReference().child("User").child(id).setValue(user);
                                Toast.makeText(signUp.this, "User Created Successfully", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(signUp.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });


        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signUp.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}