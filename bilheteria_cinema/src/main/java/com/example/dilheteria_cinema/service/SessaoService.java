package com.example.dilheteria_cinema.service;

import com.example.dilheteria_cinema.entity.Sessao;
import com.example.dilheteria_cinema.exceptions.movie.NomeFilmeInvalido;
import com.example.dilheteria_cinema.exceptions.section.NameSectionNotFound;
import com.example.dilheteria_cinema.exceptions.section.TypeSectionNotFound;
import com.example.dilheteria_cinema.repository.SessaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessaoService {

    private final SessaoRepository sessaoRepository;

    public SessaoService(SessaoRepository sessaoRepository) {
        this.sessaoRepository = sessaoRepository;
    }

    public void salvarSessao(Sessao sessao) {
        sessaoRepository.saveAndFlush(sessao);
    }

    public int findCapacity(String name) {
        Sessao sessao = (Sessao)sessaoRepository.findAll().stream().filter(s->s.getName().equals(name));
        return sessao.getCapacidade() - sessao.getCadeirasOcupadas();
    }

    public List<Sessao> findByType(String type) {
        try{
            return sessaoRepository.findByType(type);
        } catch (RuntimeException e) {
            throw new TypeSectionNotFound();
        }
    }

    public List<Sessao> findSectionByNameMovie(String nameMovie) {
        try {
            return sessaoRepository.findSectionByNameMovie(nameMovie);
        } catch (RuntimeException e) {
            throw new NomeFilmeInvalido();
        }
    }

    public void deleteByNameSection(String name) {
        sessaoRepository.deleteByName(name).orElseThrow(NameSectionNotFound::new);
    }

    public void updateNameMovie(String nameMovie, String name) {
        Sessao sessao = (Sessao)sessaoRepository.findAll().stream().filter(s->s.getName().equals(name));
        sessao.setNameMovie(nameMovie);
    }
}

