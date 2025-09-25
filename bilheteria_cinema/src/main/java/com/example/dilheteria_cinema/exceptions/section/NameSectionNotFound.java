package com.example.dilheteria_cinema.exceptions.section;

public class NameSectionNotFound extends RuntimeException {
    public NameSectionNotFound() {
        super("Nome da sessao não encontrado ou esta invalido");
    }

    public NameSectionNotFound(String message) {
        super(message);
    }
}
