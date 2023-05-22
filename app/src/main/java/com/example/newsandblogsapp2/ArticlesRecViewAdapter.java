package com.example.newsandblogsapp2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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

import java.io.Serializable;
import java.util.ArrayList;

public class ArticlesRecViewAdapter extends RecyclerView.Adapter<ArticlesRecViewAdapter.ViewHolder>{
    private ArrayList<ArticlesHome> articlesHomes = new ArrayList<>();
    private Context context;

    public ArticlesRecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ArticlesRecViewAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.artiles_list_view,parent,false);
        ArticlesRecViewAdapter.ViewHolder viewHolder = new ArticlesRecViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ArticlesRecViewAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.txtTitle1.setText(articlesHomes.get(position).getTitle());
        holder.txtAuthur1.setText(articlesHomes.get(position).getAuthorName());
        Glide.with(context)
                .asBitmap()
                .load(articlesHomes.get(position).getImgUrl())
                .into(holder.image1);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, articlesHomes.get(position).getId() + " is selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, DetailedActivity.class);
                intent.putExtra("detail", articlesHomes.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articlesHomes.size();
    }

    public void setArticles(ArrayList<ArticlesHome> articlesHomes) {
        this.articlesHomes = articlesHomes;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtTitle1, txtAuthur1;
        private ImageView image1;
        private RelativeLayout parent1;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            txtTitle1 = itemView.findViewById(R.id.txtTitle1);
            txtAuthur1 = itemView.findViewById(R.id.txtSource1);
            image1 = itemView.findViewById(R.id.imageBook);
            parent1 = itemView.findViewById(R.id.articleParent);
        }
    }
}
