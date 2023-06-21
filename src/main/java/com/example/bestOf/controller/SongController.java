package com.example.bestOf.controller;

import com.example.bestOf.model.Movie;
import com.example.bestOf.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public String songDetail(
            Model model,
            @PathVariable int id
    ) {
        Song song = null;
        for (Song s : getBestSongs()) {
            if(s.getId() == id) {
                song = s;
            }
        }

        if(song != null) {
            model.addAttribute("song", song);
            return "songDetail";
        } else {
            return "redirect:/home";
        }
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
