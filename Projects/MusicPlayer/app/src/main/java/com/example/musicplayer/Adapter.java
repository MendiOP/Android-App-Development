package com.example.musicplayer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private final RecyclerviewInterface recyclerviewInterface;
    private ArrayList<SongListClass> songListClasses;

    public Adapter(ArrayList<SongListClass> songListClasses, RecyclerviewInterface recyclerviewInterface) {
        this.songListClasses = songListClasses;
        this.recyclerviewInterface = recyclerviewInterface;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        int resource = songListClasses.get(position).getImageView();
        String song = songListClasses.get(position).getSongName();

        holder.setData(resource, song);
    }

    @Override
    public int getItemCount() {
        return songListClasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView songName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            songName = itemView.findViewById(R.id.songName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerviewInterface != null)
                    {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION)
                        {
                            recyclerviewInterface.setOnItemClick(position);
                        }
                    }
                }
            });
        }

        public void setData(int resource, String song) {
            imageView.setImageResource(resource);
            songName.setText(song);
        }
    }
}
