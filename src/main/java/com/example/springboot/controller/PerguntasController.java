package com.example.springboot.controller;

import com.example.springboot.model.Perguntas;
import com.example.springboot.repository.PerguntasRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perguntas")
@CrossOrigin("*")

public class PerguntasController {

    private final PerguntasRepository perguntasRepository;

    public PerguntasController(PerguntasRepository perguntasRepository) {
        this.perguntasRepository = perguntasRepository;
    }

    @GetMapping
    public List<Perguntas> listar() {
        return perguntasRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perguntas> buscar(@PathVariable Long id) {
        return perguntasRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Perguntas> criar(@RequestBody Perguntas pergunta) {
        return ResponseEntity.ok(perguntasRepository.save(pergunta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Perguntas> atualizar(@PathVariable Long id, @RequestBody Perguntas pergunta) {
        return perguntasRepository.findById(id).map(p -> {
            pergunta.setId(id);
            return ResponseEntity.ok(perguntasRepository.save(pergunta));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!perguntasRepository.existsById(id))
            return ResponseEntity.notFound().build();

        perguntasRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
