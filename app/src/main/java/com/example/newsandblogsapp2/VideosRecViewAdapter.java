package com.example.newsandblogsapp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class VideosRecViewAdapter extends RecyclerView.Adapter<VideosRecViewAdapter.ViewHolder>{

    private ArrayList<Videos> videos = new ArrayList<>();
    private Context context;

    public VideosRecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.videos_list_item, parent, false);
        VideosRecViewAdapter.ViewHolder holder = new VideosRecViewAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull VideosRecViewAdapter.ViewHolder holder, int position) {

        holder.videoCategory.setText(videos.get(position).getVideoCategory());
        holder.videoTitle.setText(videos.get(position).getVideoTitle());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, videos.get(position).getVideoTitle() + " Selected", Toast.LENGTH_SHORT).show();
            }
        });
        Glide.with(context)
                .asBitmap()
                .load(videos.get(position).getVideoURL())
                .into(holder.videoURL);
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public void setVideos(ArrayList<Videos> videos) {
        this.videos = videos;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView videoCategory;
        private TextView videoTitle;
        private ImageView videoURL;
        private CardView parent;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            videoCategory = itemView.findViewById(R.id.txtVideoCategory);
            videoTitle = itemView.findViewById(R.id.txtTitleVideo);
            videoURL = itemView.findViewById(R.id.imageVideo);
            parent = itemView.findViewById(R.id.videosParent);
        }
    }
}
