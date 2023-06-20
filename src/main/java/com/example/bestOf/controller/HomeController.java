package com.example.bestOf.controller;
import com.example.bestOf.model.Movie;
import com.example.bestOf.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "Thomas");
        return "home";
    }

    @GetMapping("/movies")
    public String getMovies(Model model) {
        List<Movie> movies = getBestMovies();
        String listMovies = "";
        for (Movie movie : movies){
            listMovies += movie.getTitle() + ", ";
        }
        model.addAttribute("listMovies", listMovies);
        return "movies";
    }

    @GetMapping("/songs")
    public String getSongs(Model model) {
        List<Song> songsList = getBestSongs();
        String listSongs = "";
        for(Song songs : songsList){
            listSongs += songs.getTitle() + ", ";
        }
        model.addAttribute("listSongs", listSongs);
        return "songs";
    }

    private List<Movie> getBestMovies() {
        // lista di oggetti Movie rappresentanti i migliori film
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "C'era una volta ad Hollywood"));
        movies.add(new Movie(2, "Bastardi senza gloria"));
        movies.add(new Movie(3, "Pulp Fiction"));
        return movies;
    }

    private List<Song> getBestSongs() {
        // lista di oggetti Song rappresentanti le migliori canzoni
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(1, "Bocca di rosa"));
        songs.add(new Song(2, "Anna e Marco"));
        songs.add(new Song(3, "Il pescatore"));
        return songs;
    }


}
