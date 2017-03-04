package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    @Test
    public void get_title_of_movie() {
        Movie movie = new Movie("Some movie", 1);

        assertEquals("Some movie", movie.getTitle());
    }

    @Test
    public void get_publication_year_of_movie() {
        Movie movie = new Movie("Some movie", 1);
        movie.setPublicationYear(1900);

        assertEquals(1900, movie.getPublicationYear());
    }

    @Test
    public void get_director_of_movie() {
        Movie movie = new Movie("Some movie", 1);
        movie.setDirector("Director");

        assertEquals("Director", movie.getDirector());
    }

    @Test
    public void get_rating_should_return_one() throws Exception {
        Movie movie = new Movie("Some movie", 1);
        movie.setRating(1);

        Rating rating = movie.getRating();

        assertEquals("1", rating.getValue());
    }

    @Test
    public void get_rating_should_return_unrated() {
        Movie movie = new Movie("Some movie", 1);
        Rating rating = movie.getRating();

        assertEquals("unrated", rating.getValue());
    }
}