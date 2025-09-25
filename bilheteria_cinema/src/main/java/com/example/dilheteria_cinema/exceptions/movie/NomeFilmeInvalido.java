package com.example.dilheteria_cinema.exceptions.movie;

public class NomeFilmeInvalido extends RuntimeException {
    public NomeFilmeInvalido() {
        super("Nome invalido ou não encontrado");
    }

    public NomeFilmeInvalido(String message) {
        super(message);
    }
}
