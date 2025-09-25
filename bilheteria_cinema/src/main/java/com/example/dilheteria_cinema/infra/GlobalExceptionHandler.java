package com.example.dilheteria_cinema.infra;

import com.example.dilheteria_cinema.exceptions.movie.ClassificationMovieNoFound;
import com.example.dilheteria_cinema.exceptions.movie.GeneroMovieNotFound;
import com.example.dilheteria_cinema.exceptions.movie.NomeFilmeInvalido;
import com.example.dilheteria_cinema.exceptions.section.NameSectionNotFound;
import com.example.dilheteria_cinema.exceptions.section.TypeSectionNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler<T> {

    @ExceptionHandler(NomeFilmeInvalido.class)
    private ResponseEntity<String> handlerFilmeNaoEncontrado(NomeFilmeInvalido nome) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(nome.getMessage());
    }

    @ExceptionHandler(GeneroMovieNotFound.class)
    private ResponseEntity<String> handlerGeneroNoFound (GeneroMovieNotFound genero) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(genero.getMessage());
    }

    @ExceptionHandler(ClassificationMovieNoFound.class)
    private ResponseEntity<String> hendlerClassificacao(ClassificationMovieNoFound classificacao) {
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(classificacao.getMessage());
    }

    @ExceptionHandler(NameSectionNotFound.class)
    private ResponseEntity<String> handlerNameSection(NameSectionNotFound nameSectionNotFound) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(nameSectionNotFound.getMessage());
    }

    @ExceptionHandler(TypeSectionNotFound.class)
    private ResponseEntity<String> handlerTypeSection(TypeSectionNotFound typeSectionNotFound) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(typeSectionNotFound.getMessage());
    }
}
