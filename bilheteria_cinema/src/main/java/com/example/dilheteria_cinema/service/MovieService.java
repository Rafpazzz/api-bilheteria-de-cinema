package com.example.dilheteria_cinema.service;

import com.example.dilheteria_cinema.entity.Movie;
import com.example.dilheteria_cinema.exceptions.movie.ClassificationMovieNoFound;
import com.example.dilheteria_cinema.exceptions.movie.GeneroMovieNotFound;
import com.example.dilheteria_cinema.exceptions.movie.NomeFilmeInvalido;
import com.example.dilheteria_cinema.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public void salvarFilme(Movie filme) {
        repository.saveAndFlush(filme);
    }

    public Movie findByName(String name) {
        Movie movie = repository.findByName(name).orElseThrow(NomeFilmeInvalido::new);

        return movie;
    }

    public List<Movie> findByGenero(String genero) {
        List<Movie> resulte = repository.findByGenero(genero);
        if (resulte.isEmpty()) {
            throw new GeneroMovieNotFound();
        }

        return resulte;
    }

    public List<Movie> findCartasIsTrue() {
        return repository.findAll().stream().filter(Movie::isInCartaz).collect(Collectors.toList());
    }

    public List<Movie> findByClassificacao(int classificacao) {
        List<Movie> resulte = repository.findByClassificacao(classificacao);
        if (resulte.isEmpty()) {
            throw new ClassificationMovieNoFound();
        }

        return resulte;
    }

    public List<Movie> findAllMovies() {
        return repository.findAll();
    }

    public void deleteByName(String name) {
        repository.deleteByName(name);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
