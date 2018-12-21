package com.example.bruger.test;

/**
 * Created by Bruger on 30-11-2018.
 */

public class Establishment {

    String name, address, description, type;
    double lat, lng, rating;
    int img;


    public Establishment(String name, String address, String description, String type, double lat, double lng, double rating, int img) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.type = type;
        this.lat = lat;
        this.lng = lng;
        this.rating = rating;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public int getImg(){return img;}

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public double getRating() {
        return rating;
    }
}
