package com.twu.biblioteca.models;

public class Movie extends Media {
    private Rating movieRating;

    public Movie(String movieTitle, int ID, int publicationYear, String director) {
        super(movieTitle, ID, publicationYear, director);
        movieRating = new Rating();
    }

    public void setRating(int rate) throws Exception {
        this.movieRating.setValue(rate);
    }

    public String getDirector() {
        return this.getAuthor();
    }

    public Rating getRating() {
        return this.movieRating;
    }
}
