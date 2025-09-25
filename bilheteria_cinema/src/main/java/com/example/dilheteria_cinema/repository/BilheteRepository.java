package com.example.dilheteria_cinema.repository;

import com.example.dilheteria_cinema.entity.Bilhete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface BilheteRepository extends JpaRepository<Bilhete, Integer> {

    //List<Bilhete> findAllBilhetes();

//    List<Bilhete> findByData(LocalDate date);

    @Transactional
    void deleteById(int id);
}
