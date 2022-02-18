package com.example.movieworkshoptemplate.services;

import com.example.movieworkshoptemplate.models.Movie;
import com.example.movieworkshoptemplate.repositories.MovieDataRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;

public class MovieService {
    MovieDataRepository movieRepo = new MovieDataRepository();

    //Services called from controllers that returns what the client requests

    public String getFirst() throws FileNotFoundException {
        ArrayList<Movie> movieLib = movieRepo.allMovies();
        return movieLib.get(0).getTitle();
    }

    public String getRandom() throws FileNotFoundException {
        ArrayList<Movie> movieLib = movieRepo.allMovies();
        Random rand = new Random();

        int randomNum = rand.nextInt(1584);
        return movieLib.get(randomNum).getTitle();
    }

    public String getTenSortByPopularity() throws FileNotFoundException {
        Random rand = new Random();
        ArrayList<Movie> movieLib = movieRepo.allMovies();
        ArrayList<Movie> tenRand = new ArrayList<Movie>();

        for (int i = 1; i <= 10; i++){
            int randomNum = rand.nextInt(1584);
            tenRand.add(movieLib.get(randomNum));
        }
        Collections.sort(tenRand);
        String tenRandStr = "";
        for (int j = 0; j <= tenRand.size(); j++){
            tenRandStr = tenRandStr + tenRand.get(j).toString();
        }
        return tenRandStr;
    }

    public String howManyWonAnAward() throws FileNotFoundException {
        ArrayList<Movie> movieLib = movieRepo.allMovies();
        int counter = 0;

        for (int i = 0; i <= (movieLib.size()); i++){
            if (movieLib.get(i).getHasAwards().equals("Yes")){
                counter++;
            }
        }
        return "" + counter;
    }

    public String longest(String g1, String g2) throws FileNotFoundException {
        ArrayList<Movie> movieLib = movieRepo.allMovies();
        double avgG1 = 0;
        double avgG2 = 0;
        int counter1 = 0;
        int counter2 = 0;

        for (int i = 0; i <= movieLib.size()-1; i++){
            if (movieLib.get(i).getSubject().equals(g1)){
                counter1++;
                avgG1 = avgG1 + movieLib.get(i).getLength();
            }
            else if (movieLib.get(i).getSubject().equals(g2)){
                counter2++;
                avgG2 = avgG2 + movieLib.get(i).getLength();
            }
        }

        avgG1 = avgG1/counter1;
        avgG2 = avgG2/counter2;
        String result1 = String.format("%.2f", avgG1);
        String result2 = String.format("%.2f", avgG2);

        if (avgG1<avgG2){
            return "<h3>" + g2 + " er længere end " + g1.toLowerCase(Locale.ROOT) + " med en gennemsnitlig længde på " + result2 + "min<h3>";
        }
        else if (avgG1>avgG2){
            return "<h3>" + g1+ " er længere end " + g2.toLowerCase(Locale.ROOT) + " med en gennemsnitlig længde på " + result1 + "min<h3>";
        }
        else {
            return "<h3>" +g1 + " og " + g2.toLowerCase(Locale.ROOT) + " har gennemsnitlig samme længde på " + result1 + "min.<h3>";
        }
    }
}
