package com.example.movieworkshoptemplate.controllers;

import com.example.movieworkshoptemplate.models.Movie;
import com.example.movieworkshoptemplate.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.ArrayList;

@RestController
public class MovieController {
    MovieService movService = new MovieService();

    //Controller methods

    @GetMapping("/")
    public String index(){
        return "<h1>Filmdatabase<h1>" + "<h3>Denne hjemmeside kan bruges til at finde information om film<h3>";
    }

    @GetMapping("/getFirst")
    public String getFirst() throws FileNotFoundException {
        String first = movService.getFirst();
        return "<h1>Første film i databasen:<h1>" + "<h3><h3>" +first;
    }

    @GetMapping("/getRandom")
    public String getRandom() throws FileNotFoundException {
        String random = movService.getRandom();
        return "<h1>Tilfældig film:<h1>" + "<h3><h3>" + random;
    }

    @GetMapping("/getTenSortByPopularity")
    public String getTenSortByPopularity() throws FileNotFoundException {
        String tenRand = movService.getTenSortByPopularity();
        return "<h1>10 tilfældige film, sorteret efter popularitet:<h1>" + tenRand;
    }

    @GetMapping("/howManyWonAnAward")
    public String howManyWonAnAward() throws FileNotFoundException {
        String counter = movService.howManyWonAnAward();
        return "<h1>Hvor mange har vundet en award: <h1>" + "<h5><h5>" + counter;
    }

    @GetMapping("/longest")
    public String longest(@RequestParam String g1, String g2) throws FileNotFoundException {
        String longestGenre = movService.longest(g1,g2);
        return  "<h1>Sammenligning af længden på 2 genre:<h1>" + longestGenre;
    }
}
