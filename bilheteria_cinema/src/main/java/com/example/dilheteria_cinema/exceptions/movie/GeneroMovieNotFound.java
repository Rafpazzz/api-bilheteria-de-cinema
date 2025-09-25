package com.example.dilheteria_cinema.exceptions.movie;

public class GeneroMovieNotFound extends RuntimeException {
    public GeneroMovieNotFound() {
        super("Genero passado é invalodo ou não há filmes desse genero");
    }

    public GeneroMovieNotFound(String message) {
        super(message);
    }
}
