package com.dvd.model;

public class DVDItem implements java.io.Serializable {

    public String title;
    public String year;
    public String genre;

    public DVDItem(String title, String year, String genre) {
        this.title = title;
        this.year = year;
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }
}
