package com.example.newsandblogsapp2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReadingViewMain extends AppCompatActivity {

    private TextView title, source, txtShortDesc, txtLognDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_view_main);

        init();


    }

    private void init()
    {
        title = findViewById(R.id.title);
        source = findViewById(R.id.source);
        txtShortDesc = findViewById(R.id.txtShortDesc);
        txtLognDesc = findViewById(R.id.txtLongDesc);
    }
}