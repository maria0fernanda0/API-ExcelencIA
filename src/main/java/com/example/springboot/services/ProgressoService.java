package com.example.springboot.services;

import com.example.springboot.model.Progresso;
import com.example.springboot.repository.ProgressoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProgressoService {

    @Autowired
    private ProgressoRepository progressoRepository;


    // Criar progresso
    public Progresso create(Progresso progresso) {
        return progressoRepository.save(progresso);
    }


    // Listar todos
    public List<Progresso> findAll() {
        return progressoRepository.findAll();
    }


    // Buscar por ID
    public Optional<Progresso> findById(Long id) {
        return progressoRepository.findById(id);
    }

    // Atualizar progresso
    public Progresso update(Long id, Progresso dadosAtualizados) {
        return progressoRepository.findById(id)
                .map(progresso -> {
                    progresso.setUsuario(dadosAtualizados.getUsuario());
                    progresso.setUltimaSimulacao(dadosAtualizados.getUltimaSimulacao());
                    progresso.setDadosEvolucao(dadosAtualizados.getDadosEvolucao());
                    return progressoRepository.save(progresso);
                })
                .orElseThrow(() -> new RuntimeException("Progresso não encontrado"));
    }

    // Deletar
    public void delete(Long id) {
        progressoRepository.deleteById(id);
    }

}
