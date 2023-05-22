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

import java.util.ArrayList;

public class ScienceRecViewAdapter extends RecyclerView.Adapter<ScienceRecViewAdapter.ViewHolder>{

    private ArrayList<Science> sciences = new ArrayList<>();
    private Context context;

    public ScienceRecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.science_list_view,parent,false);
        ScienceRecViewAdapter.ViewHolder viewHolder = new ScienceRecViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.txtTitleScience.setText(sciences.get(position).getTitle());
        holder.txtSourceScience.setText(sciences.get(position).getAuthorName());
        Glide.with(context)
                .asBitmap()
                .load(sciences.get(position).getImgUrl())
                .into(holder.imageScience);
        holder.scienceParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, sciences.get(position).getId() + " is selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setScience(ArrayList<Science> sciences) {
        this.sciences = sciences;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return sciences.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtTitleScience, txtSourceScience;
        private ImageView imageScience;
        private RelativeLayout scienceParent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitleScience = itemView.findViewById(R.id.txtTitleSciene);
            txtSourceScience = itemView.findViewById(R.id.txtSourceScience);
            imageScience = itemView.findViewById(R.id.imageScience);
            scienceParent = itemView.findViewById(R.id.scienceParent);
        }
    }
}
