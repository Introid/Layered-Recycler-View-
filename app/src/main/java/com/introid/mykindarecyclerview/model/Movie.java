package com.introid.mykindarecyclerview.model;

import java.io.Serializable;

public class Movie implements Serializable {

    private String moviePictureURL;

    public Movie() {
    }

    public Movie( String moviePictureURL) {

        this.moviePictureURL = moviePictureURL;
    }



    public String getMoviePictureURL() {
        return moviePictureURL;
    }

    public void setMoviePictureURL(String moviePictureURL) {
        this.moviePictureURL = moviePictureURL;
    }
}
