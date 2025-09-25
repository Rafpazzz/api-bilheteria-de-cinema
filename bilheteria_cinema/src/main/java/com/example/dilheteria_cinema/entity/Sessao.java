package com.example.dilheteria_cinema.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "sessao")
public class Sessao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name_Seccao")
    private String name;

    @Column(name = "capacidade")
    private int capacidade;

    @Column(name = "tipo")
    private String type;

    @Column(name = "isFull")
    private boolean isFull;

    @Column(name = "cadeirasOcupadas")
    private int cadeirasOcupadas;

    @Column(name = "movie_name")
    private String nameMovie;

}
