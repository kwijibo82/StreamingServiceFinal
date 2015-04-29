package com.example.video.testvideostreaming;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by PC on 18/04/2015.
 */
public class VerVideo extends Activity  {
    private final String URLTXT = "http://projecteuf2.esy.es/videos.txt";
    private final String URLVIDEO = "http://projecteuf2.esy.es/upload/";
    private ArrayList<Video> videos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vervideos);
        this.videos = new ArrayList();
        this.llenarLista();

        VideoAdapter adapter = new VideoAdapter(this,this.videos);
        ListView list = (ListView) this.findViewById(R.id.ListViewVideos);
        list.setAdapter(adapter);
        final TextView prueba = (TextView) findViewById(R.id.ListViewVideoName);
        list.setOnItemClickListener(new ListView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(
                        VerVideo.this, VideoViewActivity.class);
                startActivity(intent);
                Bundle bundle = new Bundle();
                bundle.putString("url", videos.get(position).getUrl());
                bundle.putString("nombre", videos.get(position).getNombre());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    /*   @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }
    /**/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void llenarLista()
    {
        try
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            URL url = new URL(URLTXT);

            //Obtiene archivos del servidor mediante el archivo de registro
            BufferedReader sc = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = sc.readLine();
            while(line != null)
            {
                //El archivo controla los diferentes archivos subidos mediante el carácter ';'
                String []videos_ = line.split(";");
                for(String video : videos_)
                {
                    String formato = video.substring(video.lastIndexOf('.'),video.length());
                    if( formato.equals(".mp4") || formato.equals(".3gp")) {
                        Video videoAdd = new Video(URLVIDEO + video, video);
                        videos.add(videoAdd);
                    }
                }
                line = sc.readLine();
            }
            sc.close();
            VideoAdapter adapter = new VideoAdapter(this,this.videos);
            ListView list = (ListView) this.findViewById(R.id.ListViewVideos);
            list.setAdapter(adapter);
        }
        catch (Exception e)
        {

            e.printStackTrace();
        }
    }



}
