package com.example.dilheteria_cinema.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table (name = "filme")
public class Movie {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "duracao")
    private int duracao;

    @Column(name = "classificacao")
    private int classificacao;

    @Column(name = "genero")
    private String genero;

    @Column(name = "data_lancamento")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataLancamento;

    @Column(name = "in_cartaz")
    private boolean inCartaz;

}
