package com.twu.biblioteca;

import com.twu.biblioteca.models.Rating;
import org.junit.Test;

import static org.junit.Assert.*;

public class RatingTest {

    @Test
    public void get_value_should_return_1() throws Exception {
        Rating rating = new Rating();
        rating.setValue(1);

        assertEquals(1, rating.getValue());
    }

    @Test
    public void get_value_should_return_10() throws Exception {
        Rating rating = new Rating();
        rating.setValue(10);

        assertEquals(10, rating.getValue());
    }

    @Test
    public void is_rated_should_return_false_if_movie_is_not_rated() {
        Rating rating = new Rating();

        assertFalse(rating.isRated());
    }

    @Test
    public void is_rated_should_return_true_if_movie_is_rated() throws Exception {
        Rating rating = new Rating();
        rating.setValue(5);

        assertTrue(rating.isRated());
    }

    @Test
    public void get_value_should_return_exception() {
        Rating rating = new Rating();
        boolean excep = false;

        try {
            rating.setValue(11);
        } catch (Exception e) {
            excep = true;
        }

        assertTrue(excep);
    }
}