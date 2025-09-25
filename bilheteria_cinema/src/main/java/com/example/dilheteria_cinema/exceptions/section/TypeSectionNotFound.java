package com.example.dilheteria_cinema.exceptions.section;

public class TypeSectionNotFound extends RuntimeException {
    public TypeSectionNotFound() {
        super("Tipo de sessão buscado não existe");
    }

    public TypeSectionNotFound(String message) {
        super(message);
    }
}
