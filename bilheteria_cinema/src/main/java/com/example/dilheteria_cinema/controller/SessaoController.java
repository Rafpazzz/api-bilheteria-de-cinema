package com.example.dilheteria_cinema.controller;

import com.example.dilheteria_cinema.entity.Sessao;
import com.example.dilheteria_cinema.service.SessaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessao")
public class SessaoController {
    private final SessaoService sessaoServise;

    public SessaoController (SessaoService service) {
        sessaoServise = service;
    }

    @PostMapping
    public ResponseEntity<String> savaSection(@RequestBody Sessao section) {
        sessaoServise.salvarSessao(section);
        return ResponseEntity.ok("Section save with success");
    }

    @GetMapping("/find-capacity")
    public ResponseEntity<Integer> findByCapacity(@RequestParam String name) {
        return ResponseEntity.ok(sessaoServise.findCapacity(name));
    }

    @GetMapping("/find-type")
    public ResponseEntity<List<Sessao>> findByType(@RequestParam String type) {
        return ResponseEntity.ok(sessaoServise.findByType(type));
    }

    @GetMapping("/find-by-movie")
    public ResponseEntity<List<Sessao>> findByMovie(@RequestParam String movieName) {
        return ResponseEntity.ok(sessaoServise.findSectionByNameMovie(movieName));
    }

    @DeleteMapping("/delete-section")
    public ResponseEntity<Void> deleteSectionByNameSection(@RequestParam String name) {
        sessaoServise.deleteByNameSection(name);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/atualizar-nome-filme-sessao")
    public ResponseEntity<Void> updateNameMovieSection(@RequestParam String nameMovie, @RequestParam String name) {
        sessaoServise.updateNameMovie(nameMovie,name);
        return ResponseEntity.ok().build();
    }
}
