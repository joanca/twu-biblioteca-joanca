package test.java.com.twu.biblioteca.models;

import main.java.com.twu.biblioteca.models.Movie;
import main.java.com.twu.biblioteca.models.Rating;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    @Test
    public void get_title_of_movie() {
        Movie movie = new Movie("Some movie", 1, 1, "some person");

        assertEquals("Some movie", movie.getTitle());
    }

    @Test
    public void get_publication_year_of_movie() {
        Movie movie = new Movie("Some movie", 1, 1, "some person");

        assertEquals(1, movie.getPublicationYear());
    }

    @Test
    public void get_director_of_movie() {
        Movie movie = new Movie("Some movie", 1, 1, "Director");

        assertEquals("Director", movie.getDirector());
    }

    @Test
    public void get_rating_should_return_one() throws Exception {
        Movie movie = new Movie("Some movie", 1, 1, "some person");
        movie.setRating(1);

        Rating rating = movie.getRating();

        assertEquals(1, rating.getValue());
    }

}