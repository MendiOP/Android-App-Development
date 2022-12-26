package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;

public class SongsList extends AppCompatActivity implements RecyclerviewInterface{
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    Adapter adapter;
    ArrayList<SongListClass> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_list);

        generateSongs();
    }

    public void generateSongs()
    {
        ArrayList<File> songs = getSongList(Environment.getExternalStorageDirectory());
        String[] songNames = new String[songs.size()];
        for(int i=0; i<songs.size(); i++)
            songNames[i] = songs.get(i).getName().replace(".mp3", "");

        initData(songNames);
        initRecyclerView();

    }

    private void initData(String[] strings)
    {
        arrayList = new ArrayList<>();
        for(String s : strings)
            arrayList.add(new SongListClass(R.drawable.musiclogo, s));
    }

    private void initRecyclerView()
    {
        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(arrayList, this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private ArrayList<File> getSongList(File file)
    {
        ArrayList<File> arrayList = new ArrayList<>();
        File[] songs = file.listFiles();

        if(songs != null)
        {
            for(File f : songs)
            {
                if(!f.isHidden() && f.isDirectory())
                    arrayList.addAll(getSongList(f));
                else
                {
                    if(f.getName().endsWith(".mp3") && !f.getName().startsWith("."))
                        arrayList.add(f);
                }
            }
        }
        return arrayList;
    }

    @Override
    public void setOnItemClick(int position) {
        Intent intent1 = new Intent(SongsList.this, PlayingSong.class);

        String currentSong = arrayList.get(position).getSongName();
        ArrayList<File> songlist = getSongList(Environment.getExternalStorageDirectory());

        intent1.putExtra("songlist", songlist);
        intent1.putExtra("currentsong", currentSong);
        intent1.putExtra("position", position);

        startActivity(intent1);
        //Toast.makeText(this, song, Toast.LENGTH_LONG).show();
    }
}