package main.java.com.twu.biblioteca.models;

public class Rating {
    private int ratingValue;
    private boolean isRated = false;

    public Rating() {}

    public void setValue(int value) throws Exception {
        if(value > 10 || value < 0)
            throw new Exception("Valor fuera de rango.");

        this.isRated = true;
        this.ratingValue = value;
    }

    public int getValue() {
        return ratingValue;
    }

    public boolean isRated() {
        return isRated;
    }
}
