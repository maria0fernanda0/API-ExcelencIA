package com.example.springboot.controller;

import com.example.springboot.model.Respostas;
import com.example.springboot.repository.RespostasRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/respostas")
@CrossOrigin("*")

public class RespostasController {

    private final RespostasRepository respostasRepository;

    public RespostasController(RespostasRepository respostasRepository) {
        this.respostasRepository = respostasRepository;
    }

    @GetMapping
    public List<Respostas> listar() {
        return respostasRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Respostas> buscar(@PathVariable Long id) {
        return respostasRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Respostas> criar(@RequestBody Respostas resposta) {
        return ResponseEntity.ok(respostasRepository.save(resposta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Respostas> atualizar(@PathVariable Long id, @RequestBody Respostas resposta) {
        return respostasRepository.findById(id).map(r -> {
            resposta.setId(id);
            return ResponseEntity.ok(respostasRepository.save(resposta));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!respostasRepository.existsById(id))
            return ResponseEntity.notFound().build();

        respostasRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
