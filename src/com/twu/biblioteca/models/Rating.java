package com.twu.biblioteca.models;

public class Rating {
    private String ratingValue = "unrated";

    public Rating() {}

    public void setValue(int value) throws Exception {
        if(value > 10 || value < 0)
            throw new Exception("Valor fuera de rango.");

        this.ratingValue = String.valueOf(value);
    }

    public String getValue() {
        return ratingValue;
    }
}
