package com.example.bruger.test;

/**
 * Created by Bruger on 29-11-2018.
 */

public class Post {

    private String title, location, type;

    public Post(String title, String location, String type) {
        this.title = title;
        this.location = location;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

}
