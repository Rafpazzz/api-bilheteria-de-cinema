package com.example.dilheteria_cinema.service;

import com.example.dilheteria_cinema.entity.Bilhete;
import com.example.dilheteria_cinema.repository.BilheteRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BilheteService {
    private final BilheteRepository repository;

    public BilheteService(BilheteRepository repository) {
        this.repository = repository;
    }

    public void salvarBilhete(Bilhete bilhete) {
        repository.saveAndFlush(bilhete);
    }

    @JsonFormat(pattern = "MM/yyyy")
    public String findSumPricesByMonth(LocalDate date) {
        var result = 0.0;
        result = repository.findAll().stream().filter(b -> b.getHora_Comopra().toLocalDate().equals(date)).mapToDouble(Bilhete::getPreco).sum();
        return "O faturamento total de bilhetes é R$" + result;
    }

    @JsonFormat(pattern = "dd/MM/yyyy")
    public String findSumPricesByDate(LocalDate date) {
        var result = 0.0;
        result = repository.findAll().stream().filter(b -> b.getHora_Comopra().toLocalDate().equals(date)).mapToDouble(Bilhete::getPreco).sum();
        return "O faturamento total na data "+date+" de bilhetes é R$" + result;
    }

    public List<Bilhete> findAllBilhetes() {
        return repository.findAll();
    }

    @JsonFormat(pattern = "dd/MM/yyyy")
    public List<Bilhete> findByDate01(LocalDate date) {
        List<Bilhete> list = new ArrayList<>();
        list.add((Bilhete) repository.findAll().stream().filter(b -> b.getHora_Comopra().toLocalDate().equals(date)));

        return list;
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
