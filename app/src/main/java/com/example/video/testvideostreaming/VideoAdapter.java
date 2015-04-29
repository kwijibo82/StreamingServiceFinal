package com.example.video.testvideostreaming;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by PC on 18/04/2015.
 */
public class VideoAdapter extends ArrayAdapter {
    private Activity context;
    private Object[] videos;

    public VideoAdapter(Activity context, ArrayList<Video> videos) {
        super(context, R.layout.videoadapter, videos.toArray());
        this.context = context;
        this.videos = videos.toArray();
    }

    public View getView(int pos, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.videoadapter, null);
        TextView listText = (TextView) item.findViewById(R.id.TextViewLista);
        listText.setText(((Video) this.videos[pos]).getNombre());
        return item;
    }
}

