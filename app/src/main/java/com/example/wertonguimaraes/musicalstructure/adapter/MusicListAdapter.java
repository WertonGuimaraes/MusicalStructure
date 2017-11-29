package com.example.wertonguimaraes.musicalstructure.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wertonguimaraes.musicalstructure.R;
import com.example.wertonguimaraes.musicalstructure.model.Music;

import java.util.List;


public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.ViewHolder> {

    private List<Music> mInfoList;

    public MusicListAdapter(List<Music> infoList) {
        mInfoList = infoList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_view_items, null);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return (null != mInfoList ? mInfoList.size() : 0);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Music music = mInfoList.get(position);
        holder.mTitleView.setText(music.getTitle());
        holder.mArtistView.setText(music.getArtist());
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitleView;
        private TextView mArtistView;

        private ViewHolder(View view) {
            super(view);
            mTitleView = view.findViewById(R.id.music_title);
            mArtistView = view.findViewById(R.id.music_artist);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            Music music = mInfoList.get(getAdapterPosition());
            String messageMusicPlaying = String.format(context.getResources().getString(R.string.music_is_playing), music.getTitle());
            Toast toast = Toast.makeText(context, messageMusicPlaying, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}