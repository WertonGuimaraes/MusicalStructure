package com.example.wertonguimaraes.musicalstructure.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.wertonguimaraes.musicalstructure.R;

public class PlayMusicActivity extends AppCompatActivity {

    private Button mListMusics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_music);
        mInitView();
        mInitButtonListeners();
    }

    private void mInitView() {
        mListMusics = findViewById(R.id.list_musics_bt);
    }

    private void mInitButtonListeners() {
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
