package com.example.springboot.services;

import com.example.springboot.model.Planos;
import com.example.springboot.repository.PlanosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface PlanosService {
    List<Planos> listarTodos();
    Optional<Planos> buscarPorId(Long id);
    Planos criar(Planos plano);
    Optional<Planos> atualizar(Long id, Planos plano);
    boolean deletar(Long id);
}


