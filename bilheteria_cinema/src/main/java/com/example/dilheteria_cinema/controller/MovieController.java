package com.example.dilheteria_cinema.controller;

import com.example.dilheteria_cinema.entity.Movie;
import com.example.dilheteria_cinema.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieServise;

    @PostMapping
    public ResponseEntity<String> salvarMovie(@RequestBody Movie movie) {
        movieServise.salvarFilme(movie);
        return ResponseEntity.ok("Movie save with success");
    }

    @GetMapping("/find-by-name")
    public ResponseEntity<Movie> findByName(@RequestParam String name) {
        return ResponseEntity.ok(movieServise.findByName(name));
    }

    @GetMapping("/find-by-genero")
    public ResponseEntity<List<Movie>> findByGenero(@RequestParam String genero) {
        return  ResponseEntity.ok(movieServise.findByGenero(genero));
    }

    @GetMapping("/find-by-cartaz")
    public ResponseEntity<List<Movie>> findCartazIsTrue() {
        return ResponseEntity.ok(movieServise.findCartasIsTrue());
    }

    @GetMapping("/find-by-classification")
    public ResponseEntity<List<Movie>> findByClassification(@RequestParam int classifcation) {
        return ResponseEntity.ok(movieServise.findByClassificacao(classifcation));
    }

    @GetMapping("/find-All")
    public ResponseEntity<List<Movie>> findAllMovies() {
        return ResponseEntity.ok(movieServise.findAllMovies());
    }

    @DeleteMapping("/delete-by-name")
    public ResponseEntity<Void> removeByName(@RequestParam String name) {
        movieServise.deleteByName(name);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-by-id")
    public ResponseEntity<Void> removeById(@RequestParam int id) {
        movieServise.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
