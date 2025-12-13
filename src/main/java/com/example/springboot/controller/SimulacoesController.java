package com.example.springboot.controller;

import com.example.springboot.model.Simulacoes;
import com.example.springboot.repository.SimulacoesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/simulacoes")
@CrossOrigin("*")

public class SimulacoesController {

    private final SimulacoesRepository simulacoesRepository;

    public SimulacoesController(SimulacoesRepository simulacoesRepository) {
        this.simulacoesRepository = simulacoesRepository;
    }

    @GetMapping
    public List<Simulacoes> listar() {
        return simulacoesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Simulacoes> buscar(@PathVariable Long id) {
        return simulacoesRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Simulacoes> criar(@RequestBody Simulacoes simulacao) {
        return ResponseEntity.ok(simulacoesRepository.save(simulacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Simulacoes> atualizar(@PathVariable Long id, @RequestBody Simulacoes simulacao) {
        return simulacoesRepository.findById(id).map(s -> {
            simulacao.setId(id);
            return ResponseEntity.ok(simulacoesRepository.save(simulacao));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!simulacoesRepository.existsById(id))
            return ResponseEntity.notFound().build();

        simulacoesRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
