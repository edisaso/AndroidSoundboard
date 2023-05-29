package com.example.soundboard;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements SoundAdapter.OnItemClickListener {

    private List<Sound> soundList;
    private MediaPlayer mediaPlayer;
    private SoundAdapter soundAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soundList = new ArrayList<>();
        soundList.add(new Sound("Sound 1", R.raw.sound1));
        soundList.add(new Sound("Sound 2", R.raw.sound2));
        soundList.add(new Sound("Sound 3", R.raw.sound3));
        // Add more sounds as needed

        RecyclerView soundRecyclerView = findViewById(R.id.soundRecyclerView);
        soundAdapter = new SoundAdapter(soundList, this);
        soundRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        soundRecyclerView.setAdapter(soundAdapter);
    }

    @Override
    public void onItemClick(int position) {
        Sound sound = soundList.get(position);
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(this, sound.getSoundResource());
        mediaPlayer.start();
        Toast.makeText(this, "Playing: " + sound.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}