package com.example.dilheteria_cinema.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "bilhete")
public class Bilhete {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "assento")
    private String assento;

    @Column(name = "preco")
    private double preco;

    @Column(name = "tipo")
    private String tipoSessao;

    @Column(name = "hora_compra")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime hora_Comopra;

    @Column(name = "name_section")
    private String sessaoName;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bilhete{");
        sb.append("id_bilhete=").append(id);
        sb.append(", sessao= '").append(sessaoName).append('\'');
        sb.append(", assento='").append(assento).append('\'');
        sb.append(", tipo='").append(tipoSessao).append('\'');
        sb.append(", preco=").append(preco);
        sb.append(", hora_Comopra=").append(hora_Comopra);
        sb.append('}');
        return sb.toString();
    }
}
