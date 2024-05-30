package com.example.taskremainerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Login_page extends AppCompatActivity {

    private EditText EmailOBj,PasswordObj;
    private Button signubtnObj,SignInbtnObj;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        EmailOBj = findViewById(R.id.EmainId);
        PasswordObj = findViewById(R.id.passwordId);
        signubtnObj = findViewById(R.id.registar);
        SignInbtnObj = findViewById(R.id.login);

        mAuth = FirebaseAuth.getInstance();





        signubtnObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Login_page.this,SignUpPage.class);
                startActivity(intent);
                finish();

            }
        });
        SignInbtnObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= EmailOBj.getText().toString().trim();
                String password= PasswordObj.getText().toString().trim();

                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            Toast.makeText(Login_page.this, "log in Success", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Login_page.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        else{
                            Toast.makeText(Login_page.this, "Incorrect", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });

    }



}