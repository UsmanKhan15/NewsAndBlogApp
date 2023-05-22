package com.example.newsandblogsapp2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class NewsRecViewAdapter extends RecyclerView.Adapter<NewsRecViewAdapter.ViewHolder>{

    private ArrayList<NewsAndArticles> newsAndArticles = new ArrayList<>();
    private Context context;

    public NewsRecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NewsRecViewAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.txtTitle.setText(newsAndArticles.get(position).getTitle());
        holder.txtSource.setText(newsAndArticles.get(position).getSourceName());
        Glide.with(context)
                .asBitmap()
                .load(newsAndArticles.get(position).getImgUrl())
                .into(holder.image);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, newsAndArticles.get(position).getId() + " is selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsAndArticles.size();
    }

    public void setNewsAndArticles(ArrayList<NewsAndArticles> newsAndArticles) {
        this.newsAndArticles = newsAndArticles;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtTitle, txtSource;
        private ImageView image;
        private RelativeLayout parent;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txtTitle1);
            txtSource = itemView.findViewById(R.id.txtSource1);
            image = itemView.findViewById(R.id.imageBook);
            parent = itemView.findViewById(R.id.articleParent);
        }
    }
}
