package com.example.video.testvideostreaming;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button verVideos = (Button) this.findViewById(R.id.ButtonVerVideos);
        verVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,VerVideo.class);
                startActivity(intent);
            }
        });
        Button subirVideo = (Button) this.findViewById(R.id.ButtonSubirVideos);
        subirVideo.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

                  //Lanza un intent para subir desde la aplicación web
                  Intent intent = new Intent(Intent.ACTION_VIEW);
                  intent.setData(Uri.parse("http://projecteuf2.esy.es/uploadForm.html"));
                  startActivity(intent);
              }
          }
        );
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
    */
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
}
