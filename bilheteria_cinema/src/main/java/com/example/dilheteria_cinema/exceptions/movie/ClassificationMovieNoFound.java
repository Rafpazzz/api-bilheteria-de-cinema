package com.example.dilheteria_cinema.exceptions.movie;

public class ClassificationMovieNoFound extends RuntimeException {
    public ClassificationMovieNoFound() {
        super("Classificação invalida ou não há filmes com essa classificação");
    }

    public ClassificationMovieNoFound(String message) {
        super(message);
    }
}
