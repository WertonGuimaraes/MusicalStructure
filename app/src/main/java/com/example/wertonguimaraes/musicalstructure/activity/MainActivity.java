package com.example.wertonguimaraes.musicalstructure.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wertonguimaraes.musicalstructure.R;

public class MainActivity extends AppCompatActivity {

    private Button mPlayMusic;
    private Button mListMusics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInitView();
        mInitButtonListeners();
    }

    private void mInitView() {
        mPlayMusic = findViewById(R.id.play_music_bt);
        mListMusics = findViewById(R.id.list_musics_bt);
    }

    private void mInitButtonListeners() {
        mPlayMusic.setOnClickListener(mOpenNewActivity);
        mListMusics.setOnClickListener(mOpenNewActivity);
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
