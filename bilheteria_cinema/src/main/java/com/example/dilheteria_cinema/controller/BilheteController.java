package com.example.dilheteria_cinema.controller;

import com.example.dilheteria_cinema.entity.Bilhete;
import com.example.dilheteria_cinema.service.BilheteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/bilhete")
@RequiredArgsConstructor
public class BilheteController {
    private final BilheteService service;

    @PostMapping
    public ResponseEntity<String> saveBilhete(@RequestBody Bilhete bilhete) {
        service.salvarBilhete(bilhete);
        return ResponseEntity.ok("Ticket save with success");
    }

    @GetMapping("/find-sum-prices-by-month")
    public ResponseEntity<String> findSumPricesByMonth(@RequestParam LocalDate date) {
        return ResponseEntity.ok(service.findSumPricesByMonth(date));
    }

    @GetMapping("/find-sum-price-by-date")
    public ResponseEntity<String> findSumPricesByDate(@RequestParam LocalDate date) {
        return ResponseEntity.ok(service.findSumPricesByDate(date));
    }

    @GetMapping("/find-All-bilhetes")
    public ResponseEntity<List<Bilhete>> findAllBilhetes() {
        return ResponseEntity.ok(service.findAllBilhetes());
    }

    @GetMapping("/find-by-date-01")
    public ResponseEntity<List<Bilhete>> findByDate01(@RequestParam LocalDate date) {
        return ResponseEntity.ok(service.findByDate01(date));
    }

//    @GetMapping("/find-by-date-02")
//    public ResponseEntity<List<Bilhete>> findByDate02(@RequestParam LocalDate date) {
//        return ResponseEntity.ok(service.findByDate02(date));
//    }

    @DeleteMapping("/delete-by-id")
    public ResponseEntity<Void> deleteById(@RequestParam int id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
