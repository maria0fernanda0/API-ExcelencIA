package com.example.springboot.controller;

import com.example.springboot.model.Planos;
import com.example.springboot.repository.PlanosRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planos")
@CrossOrigin("*")

public class PlanosController {

    private final PlanosRepository planosRepository;

    public PlanosController(PlanosRepository planosRepository) {
        this.planosRepository = planosRepository;
    }

    @GetMapping
    public List<Planos> listar() {
        return planosRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planos> buscar(@PathVariable Long id) {
        return planosRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Planos> criar(@RequestBody Planos plano) {
        return ResponseEntity.ok(planosRepository.save(plano));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Planos> atualizar(@PathVariable Long id, @RequestBody Planos plano) {
        return planosRepository.findById(id).map(p -> {
            plano.setId(id);
            return ResponseEntity.ok(planosRepository.save(plano));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!planosRepository.existsById(id))
            return ResponseEntity.notFound().build();
        planosRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
