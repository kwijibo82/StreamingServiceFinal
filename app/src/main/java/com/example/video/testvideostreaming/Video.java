package com.example.video.testvideostreaming;

/**
 * Created by PC on 18/04/2015.
 */
public class Video {
    private String nombre;
    private String url;
    public Video(String url, String nombre) {
        this.url = url;
        this.nombre = nombre;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUrl() {
        return url;
    }
}