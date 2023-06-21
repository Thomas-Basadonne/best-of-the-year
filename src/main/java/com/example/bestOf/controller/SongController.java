package com.example.bestOf.controller;

import ch.qos.logback.core.model.Model;
import com.example.bestOf.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {

    @GetMapping
    public String getSongs(org.springframework.ui.Model model) {
        //       List<Song> songsList = getBestSongs();
        //       String listSongs = "";
        //       for(Song songs : songsList){
        //           listSongs += songs.getTitle() + ", ";
        //       }
        model.addAttribute("listSongs", getBestSongs());
        return "songs";
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
