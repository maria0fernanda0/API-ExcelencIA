package com.example.springboot.controller;

import com.example.springboot.model.Progresso;
import com.example.springboot.repository.ProgressoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/progresso")
@CrossOrigin("*")

public class ProgressoController {


    private final ProgressoRepository progressoRepository;

    public ProgressoController(ProgressoRepository progressoRepository) {
        this.progressoRepository = progressoRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Progresso> buscar(@PathVariable Long id) {
        return progressoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Progresso> criar(@RequestBody Progresso progresso) {
        return ResponseEntity.ok(progressoRepository.save(progresso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Progresso> atualizar(@PathVariable Long id, @RequestBody Progresso progresso) {
        return progressoRepository.findById(id).map(p -> {
            progresso.setId(id);
            return ResponseEntity.ok(progressoRepository.save(progresso));
        }).orElse(ResponseEntity.notFound().build());
    }
}
