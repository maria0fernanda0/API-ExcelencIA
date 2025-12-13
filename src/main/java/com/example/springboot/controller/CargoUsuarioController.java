package com.example.springboot.controller;

import com.example.springboot.model.CargoUsuario;
import com.example.springboot.repository.CargoUsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargo")
@CrossOrigin("*")

public class CargoUsuarioController {

    private final CargoUsuarioRepository cargosRepository;

    public CargoUsuarioController(CargoUsuarioRepository cargosRepository) {
        this.cargosRepository = cargosRepository;
    }

    @GetMapping
    public List<CargoUsuario> listar() {
        return cargosRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargoUsuario> buscar(@PathVariable Long id) {
        return cargosRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CargoUsuario> criar(@RequestBody CargoUsuario cargo) {
        return ResponseEntity.ok(cargosRepository.save(cargo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CargoUsuario> atualizar(@PathVariable Long id, @RequestBody CargoUsuario cargo) {
        return cargosRepository.findById(id).map(c -> {
            cargo.setId(id);
            return ResponseEntity.ok(cargosRepository.save(cargo));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!cargosRepository.existsById(id))
            return ResponseEntity.notFound().build();

        cargosRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
