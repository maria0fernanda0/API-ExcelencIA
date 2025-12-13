package com.example.springboot.services;

import com.example.springboot.model.CargoUsuario;
import com.example.springboot.repository.CargoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoUsuarioService {

    @Autowired
    private CargoUsuarioRepository cargoRepository;


    // Criar cargo
    public CargoUsuario create(CargoUsuario cargo) {
        return cargoRepository.save(cargo);
    }


    // Listar todos
    public List<CargoUsuario> findAll() {
        return cargoRepository.findAll();
    }


    // Buscar por ID
    public Optional<CargoUsuario> findById(Long id) {
        return cargoRepository.findById(id);
    }


    // Atualizar
    public CargoUsuario update(Long id, CargoUsuario cargoAtualizado) {
        return cargoRepository.findById(id)
                .map(cargo -> {
                    cargo.setNome(cargoAtualizado.getNome());
                    return cargoRepository.save(cargo);
                })
                .orElseThrow(() -> new RuntimeException("Cargo não encontrado"));
    }


    // Deletar
    public void delete(Long id) {
        cargoRepository.deleteById(id);
    }
}


