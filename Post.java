package com.example.bruger.test;

/**
 * Created by Bruger on 29-11-2018.
 */

public class Post {

    private int id, image;
    private String title, location, type;
    private double rating;


    public Post(int id, String title, String location, String type, double rating, int image) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.type = type;
        this.rating = rating;
        this.image = image;
    }

    public int getImage(){
        return image;
    }

    public int getId() {
        return id;
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

    public double getRating() {
        return rating;
    }
}
