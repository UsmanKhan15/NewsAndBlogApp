

package com.example.newsandblogsapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class SignupMain extends AppCompatActivity {

    private Button register;
    private EditText edtUserName, edtEmail, edtPassword, edtPasswordRe;
    private FirebaseAnalytics firebaseAnalytics;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_main);
        /**
         * Function for initialize components
         */
        init();

        /**
         * Registration
         */
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = edtUserName.getText().toString();
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                String rePassword = edtPasswordRe.getText().toString();

                if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(rePassword)){
                    Toast.makeText(SignupMain.this, "Enter All Credential", Toast.LENGTH_SHORT).show();
                }
                else if(password.length() <= 6){
                    Toast.makeText(SignupMain.this, "Please Enter Strong Password", Toast.LENGTH_SHORT).show();
                }
                else {
                    registerUser(email, password);
                }
            }
        });

    }


    private void registerUser(String email, String pass) {
            auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull @org.jetbrains.annotations.NotNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(SignupMain.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignupMain.this,MainActivityHome.class));
                        finish();
                    }
                    else {
                        Toast.makeText(SignupMain.this, "Registration Failed!!! Try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
    }

    private void init()
    {
        register = findViewById(R.id.register);
        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        auth = FirebaseAuth.getInstance();

        edtUserName = findViewById(R.id.edtUserName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtPasswordRe = findViewById(R.id.edtPasswordRe);
    }
}