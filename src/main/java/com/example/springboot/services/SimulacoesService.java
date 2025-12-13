package com.example.springboot.services;

import com.example.springboot.model.Simulacoes;
import com.example.springboot.repository.SimulacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SimulacoesService {

    @Autowired
    private SimulacoesRepository simulacaoRepository;


    // Criar simulação
    public Simulacoes create(Simulacoes simulacao) {
        return simulacaoRepository.save(simulacao);
    }


    // Buscar todas
    public List<Simulacoes> findAll() {
        return simulacaoRepository.findAll();
    }


    // Buscar por ID
    public Optional<Simulacoes> findById(Long id) {
        return simulacaoRepository.findById(id);
    }


    // Atualizar
    public Simulacoes update(Long id, Simulacoes dadosAtualizados) {
        return simulacaoRepository.findById(id)
                .map(simulacao -> {
                    simulacao.setUsuario(dadosAtualizados.getUsuario());
                    simulacao.setDataHoraInicio(dadosAtualizados.getDataHoraInicio());
                    simulacao.setDataHoraFim(dadosAtualizados.getDataHoraFim());
                    simulacao.setCargoSimulado(dadosAtualizados.getCargoSimulado());
                    simulacao.setNotaGeral(dadosAtualizados.getNotaGeral());
                    return simulacaoRepository.save(simulacao);
                })
                .orElseThrow(() -> new RuntimeException("Simulação não encontrada"));
    }


    // Deletar
    public void delete(Long id) {
        simulacaoRepository.deleteById(id);
    }
}
