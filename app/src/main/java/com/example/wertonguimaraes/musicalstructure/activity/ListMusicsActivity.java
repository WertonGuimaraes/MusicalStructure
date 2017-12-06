package com.example.wertonguimaraes.musicalstructure.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.wertonguimaraes.musicalstructure.R;
import com.example.wertonguimaraes.musicalstructure.adapter.MusicListAdapter;
import com.example.wertonguimaraes.musicalstructure.model.Music;

import java.util.ArrayList;
import java.util.List;

public class ListMusicsActivity extends AppCompatActivity {

    private Button mPlayMusic;
    private RecyclerView mRvMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_musics);
        mInitView();
        mInitButtonListeners();
        populateMusicListView();
    }

    private void mInitView() {
        mPlayMusic = findViewById(R.id.play_music_bt);
        mRvMusic = findViewById(R.id.recycler_view);
    }

    private void mInitButtonListeners() {
        mPlayMusic.setOnClickListener(mOpenNewActivity);
    }

    private void populateMusicListView() {
        List<Music> musics = new ArrayList<>();
        mRvMusic.setLayoutManager(new LinearLayoutManager(this));
        for (int i = 0; i < 50; i++) {
            String songName = String.format(getString(R.string.song_name), i);
            String songArtist = String.format(getString(R.string.song_artist), i);

            musics.add(new Music(songName, songArtist));
        }
        MusicListAdapter mMusicAdapter = new MusicListAdapter(musics);
        mRvMusic.setAdapter(mMusicAdapter);
    }

    private View.OnClickListener mOpenNewActivity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.play_music_bt:
                    startNewActivity(PlayMusicActivity.class);
                    break;
                case R.id.list_musics_bt:
                    startNewActivity(ListMusicsActivity.class);
                    break;
                default:
                    break;
            }
        }
    };

    private void startNewActivity(Class<?> activityClass) {
        Intent myIntent = new Intent(this, activityClass);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.startActivity(myIntent);
    }
}
