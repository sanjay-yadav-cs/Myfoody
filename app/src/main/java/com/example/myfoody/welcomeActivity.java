package com.example.myfoody;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class welcomeActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        getSupportActionBar().hide();
        auth=FirebaseAuth.getInstance();

        Thread thread = new Thread(){

                public void  run(){
                    try {
                        sleep(1000);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    finally {
                        if(auth.getCurrentUser()!=null){
                            Intent intent=new Intent(welcomeActivity.this,Food_catlog.class);
                            startActivity(intent);
                            finish();
                        }
                        else{
                            Intent intent = new Intent(welcomeActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
        };thread.start();
    };
}