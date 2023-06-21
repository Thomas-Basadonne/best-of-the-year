package com.example.bestOf.controller;

import com.example.bestOf.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @GetMapping
    public String getMovies(Model model) {
//        List<Movie> movies = getBestMovies();
//        String listMovies = "";
//        for (Movie movie : movies){
//            listMovies += movie.getTitle() + ", ";
//       }
        model.addAttribute("listMovies", getBestMovies());
        return "movies";
    }
    private List<Movie> getBestMovies() {
        // lista di oggetti Movie rappresentanti i migliori film
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "C'era una volta ad Hollywood"));
        movies.add(new Movie(2, "Bastardi senza gloria"));
        movies.add(new Movie(3, "Pulp Fiction"));
        return movies;
    }
}
