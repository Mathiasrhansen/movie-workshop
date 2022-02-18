package com.example.movieworkshoptemplate.repositories;

import com.example.movieworkshoptemplate.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieDataRepository {
    //Methods to get data from file

    public ArrayList<Movie> allMovies() throws FileNotFoundException {
        ArrayList<Movie> movieLibrary = new ArrayList<Movie>();
        File movieData = new File("resources/imdb-data.csv");
        Scanner movieScanner = new Scanner(movieData);
        movieScanner.nextLine();

        while (movieScanner.hasNextLine()){
            String line = movieScanner.nextLine();
            String[] stringAsArray = line.split(";");
            int year = Integer.parseInt(stringAsArray[0]);
            int length = Integer.parseInt(stringAsArray[1]);
            String title = stringAsArray[2];
            String subject = stringAsArray[3];
            int popularity = Integer.parseInt(stringAsArray[4]);
            String awards = stringAsArray[5];

            Movie currentMovie = new Movie(year, length, title, subject, popularity, awards);
            movieLibrary.add(currentMovie);

        }

        return movieLibrary;
    }
}
