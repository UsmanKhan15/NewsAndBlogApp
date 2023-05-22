package com.example.newsandblogsapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    private Button btnGuest, btnLogin, btnSignup;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firestore;
    private ImageView imageView;
    private TextView txtWelcome;

    //Animation
    Animation topAnimation, secondAnimation, thirdAnimation, lastAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        btnGuest = findViewById(R.id.btnGuest);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);
        imageView = findViewById(R.id.imgLogo);
        txtWelcome = findViewById(R.id.txtWelcome);

        topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        secondAnimation = AnimationUtils.loadAnimation(this,R.anim.second_animation);
        thirdAnimation = AnimationUtils.loadAnimation(this,R.anim.third_animation);
        lastAnimation = AnimationUtils.loadAnimation(this,R.anim.last_animation);

        //Setting animations
        imageView.setAnimation(topAnimation);
        txtWelcome.setAnimation(secondAnimation);
        btnGuest.setAnimation(thirdAnimation);
        btnLogin.setAnimation(secondAnimation);
        btnSignup.setAnimation(lastAnimation);

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser == null){
            Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();
            btnGuest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, GuestMain.class));
                }
            });

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, LoginMain.class));
                    finish();
                }
            });

            btnSignup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, SignupMain.class));
                    finish();
                }
            });
        }
        else {
            String currentUserId = firebaseAuth.getCurrentUser().getUid();
            firestore.collection("Users").document(currentUserId).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull @NotNull Task<DocumentSnapshot> task) {
                    if(task.isSuccessful()){
                        if(!task.getResult().exists()){
                            startActivity(new Intent(MainActivity.this, MainActivityHome.class));
                            finish();
                        }
                    }
                }
            });
        }
    }
}