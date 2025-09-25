package com.example.dilheteria_cinema.repository;

import com.example.dilheteria_cinema.entity.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface SessaoRepository extends JpaRepository<Sessao, Integer> {

    List<Sessao> findByType(String type);

    List<Sessao> findSectionByNameMovie(String nameMovie);

    @Transactional
    Optional<Sessao> deleteByName(String name);

}
