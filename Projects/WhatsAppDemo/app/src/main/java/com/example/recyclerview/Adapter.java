package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<ModelClass> userList;

    Adapter(List<ModelClass> userList){
        this.userList = userList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        int resource = userList.get(position).getImageView();
        String nameText = userList.get(position).getName();
        String msg = userList.get(position).getText();
        String timeText = userList.get(position).getTime();
        String dividerText = userList.get(position).getDivider();

        holder.setData(resource, nameText, msg, timeText, dividerText);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView nameView, textInView, timeView, dividerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            nameView = itemView.findViewById(R.id.nameView);
            textInView = itemView.findViewById(R.id.textInView);
            timeView = itemView.findViewById(R.id.timeView);
            dividerView = itemView.findViewById(R.id.divider);
        }

        public void setData(int resource, String name, String msg, String time, String divider) {
            imageView.setImageResource(resource);
            nameView.setText(name);
            textInView.setText(msg);
            timeView.setText(time);
            dividerView.setText(divider);
        }
    }
}
