package com.twu.biblioteca;

import java.util.concurrent.ExecutionException;

public class Movie extends Media {
    private String movieDirector;
    private Rating movieRating;

    Movie(String movieTitle, int ID) {
        super(movieTitle, ID);
        movieRating = new Rating();
    }

    public void setDirector(String director) {
        this.movieDirector = director;
    }

    public void setRating(int rate) throws Exception {
        this.movieRating.setValue(rate);
    }

    public String getDirector() {
        return this.movieDirector;
    }

    public Rating getRating() {
        return this.movieRating;
    }
}
