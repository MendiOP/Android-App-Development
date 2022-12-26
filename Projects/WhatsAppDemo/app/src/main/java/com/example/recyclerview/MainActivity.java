package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    List<ModelClass> userList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setData();
        setRecyclerView();
    }

    private void setRecyclerView() {
        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(userList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void setData() {
        userList = new ArrayList<>();
        userList.add(new ModelClass(R.drawable.img1, "Monir", "Hey !!", "10:49 AM", "________________________________________________"));
        userList.add(new ModelClass(R.drawable.img2, "Rifah", "Hey Babee", "10:49 AM", "________________________________________________"));
        userList.add(new ModelClass(R.drawable.img3, "Tumpa", "Kothaay Tumiiiii !", "10:49 AM", "________________________________________________"));
        userList.add(new ModelClass(R.drawable.img4, "Munna", "Mama asbi na? !!", "10:49 AM", "________________________________________________"));
        userList.add(new ModelClass(R.drawable.img5, "Rasul Khan", "How are you?", "10:49 AM", "________________________________________________"));
        userList.add(new ModelClass(R.drawable.img6, "Joni", "Noob halarpo !!", "09:49 AM", "________________________________________________"));
        userList.add(new ModelClass(R.drawable.img7, "Kutttaa", "Vaag !!", "10:49 AM", "________________________________________________"));
        userList.add(new ModelClass(R.drawable.img8, "Daddy", "Bari na aisoo taa ?", "10:49 AM", "________________________________________________"));
        userList.add(new ModelClass(R.drawable.img1, "Monir", "Hey !!", "10:49 AM", "________________________________________________"));
        userList.add(new ModelClass(R.drawable.img2, "Rifah", "Hey Babee", "10:49 AM", "________________________________________________"));
        userList.add(new ModelClass(R.drawable.img3, "Tumpa", "Kothaay Tumiiiii !", "10:49 AM", "________________________________________________"));
        userList.add(new ModelClass(R.drawable.img4, "Munna", "Mama asbi na? !!", "10:49 AM", "________________________________________________"));
        userList.add(new ModelClass(R.drawable.img5, "Rasul Khan", "How are you?", "10:49 AM", "________________________________________________"));
        userList.add(new ModelClass(R.drawable.img6, "Joni", "Noob halarpo !!", "09:49 AM", "________________________________________________"));
        userList.add(new ModelClass(R.drawable.img7, "Kutttaa", "Vaag !!", "10:49 AM", "________________________________________________"));
        userList.add(new ModelClass(R.drawable.img8, "Daddy", "Bari na aisoo taa ?", "10:49 AM", "________________________________________________"));
    }
}