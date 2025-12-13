package com.example.springboot.services;

import com.example.springboot.model.Perguntas;
import com.example.springboot.repository.PerguntasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PerguntasService {

    @Autowired
    private PerguntasRepository perguntasRepository;


    // Criar pergunta
    public Perguntas create(Perguntas pergunta) {
        return perguntasRepository.save(pergunta);
    }


    // Buscar todas
    public List<Perguntas> findAll() {
        return perguntasRepository.findAll();
    }


    // Buscar por ID
    public Optional<Perguntas> findById(Long id) {
        return perguntasRepository.findById(id);
    }


    // Atualizar pergunta
    public Perguntas update(Long id, Perguntas dadosAtualizados) {
        return perguntasRepository.findById(id)
                .map(pergunta -> {
                    pergunta.setTexto(dadosAtualizados.getTexto());
                    pergunta.setCargo(dadosAtualizados.getCargo());
                    pergunta.setNivelDificuldade(dadosAtualizados.getNivelDificuldade());
                    pergunta.setCategoria(dadosAtualizados.getCategoria());
                    return perguntasRepository.save(pergunta);
                })
                .orElseThrow(() -> new RuntimeException("Pergunta não encontrada"));
    }


    // Deletar pergunta
    public void delete(Long id) {
        perguntasRepository.deleteById(id);
    }
}
