package com.example.newsandblogsapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailedActivity extends AppCompatActivity {

    private TextView txtTitle, txtAuthor;
    private ImageView imgD;
    ArticlesHome articlesHome = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        final Object object = getIntent().getSerializableExtra("detail");
        if(object instanceof ArticlesHome){
            articlesHome = (ArticlesHome) object;
        }

        txtTitle = findViewById(R.id.txtTitleD);
        txtAuthor = findViewById(R.id.txtAuthorD);
        imgD = findViewById(R.id.imgD);

        if(articlesHome != null)
        {
            Glide.with(getApplicationContext()).load(articlesHome.getImgUrl()).into(imgD);
            txtTitle.setText(articlesHome.getTitle());
            txtAuthor.setText(articlesHome.getAuthorName());
        }
    }
}