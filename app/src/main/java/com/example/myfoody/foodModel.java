package com.example.myfoody;

import android.net.Uri;

public class foodModel {
    String uri;
    String name;

    public foodModel(String uri, String name) {
        this.uri = uri;
        this.name = name;
    }

    public String getImage() {
        return uri;
    }

    public void setImage(String uri) {
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
