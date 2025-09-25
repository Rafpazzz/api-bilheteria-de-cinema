package com.example.dilheteria_cinema.repository;

import com.example.dilheteria_cinema.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByGenero(String genero);

    Optional<Movie> findByName(String name);

    List<Movie> findByClassificacao(int classificacao);

//    List<Movie> findByinCartaz();

    @Transactional
    void deleteByName(String name);
}
