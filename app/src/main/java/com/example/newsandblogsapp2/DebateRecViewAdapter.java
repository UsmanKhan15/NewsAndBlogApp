package com.example.newsandblogsapp2;

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

public class DebateRecViewAdapter extends RecyclerView.Adapter<DebateRecViewAdapter.ViewHolder>{
    private ArrayList<Debate> debates = new ArrayList<>();
    private Context context;

    public DebateRecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.debate_list_view,parent,false);
        DebateRecViewAdapter.ViewHolder viewHolder = new DebateRecViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DebateRecViewAdapter.ViewHolder holder, int position) {
        holder.txtTitleDebate.setText(debates.get(position).getTitle());
        holder.txtAuthurDebate.setText(debates.get(position).getAuthorName());
        Glide.with(context)
                .asBitmap()
                .load(debates.get(position).getImgUrl())
                .into(holder.imageDebate);
        holder.parentDebate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, debates.get(position).getId() + " is selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return debates.size();
    }

    public void setDebates(ArrayList<Debate> debates) {
        this.debates = debates;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtTitleDebate, txtAuthurDebate;
        private ImageView imageDebate;
        private RelativeLayout parentDebate;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            txtTitleDebate = itemView.findViewById(R.id.txtTitleDebate);
            txtAuthurDebate = itemView.findViewById(R.id.txtSourceDebate);
            imageDebate = itemView.findViewById(R.id.imageDebate);
            parentDebate = itemView.findViewById(R.id.debateParent);
        }
    }
}
