package com.example.movieworkshoptemplate.models;

//Movie POJO
public class Movie implements Comparable<Movie> {
    private int year;
    private int length;
    private String title;
    private String subject;
    private int popularity;
    private String hasAwards;

    public Movie(int year, int length, String title, String subject,int popularity, String hasAwards) {
        this.year = year;
        this.length = length;
        this.title = title;
        this.subject = subject;
        this.popularity = popularity;
        this.hasAwards = hasAwards;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getHasAwards() {
        return hasAwards;
    }

    public void setHasAwards(String hasAwards) {
        this.hasAwards = hasAwards;
    }

    @Override
    public int compareTo(Movie o) {
        if (popularity == o.popularity)
            return 0;
        else if (popularity > o.popularity)
            return 1;
        else
            return -1;
    }

    @Override
    public String toString(){
        return "<h4>" + title + " (" + year + ") Popularity: " + popularity + "<h4>";
    }
}
