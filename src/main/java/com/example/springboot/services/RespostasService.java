package com.example.springboot.services;

import com.example.springboot.model.Respostas;
import com.example.springboot.repository.RespostasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespostasService {

    @Autowired
    private RespostasRepository respostaRepository;


    // Criar resposta
    public Respostas create(Respostas resposta) {
        return respostaRepository.save(resposta);
    }


    // Buscar todas
    public List<Respostas> findAll() {
        return respostaRepository.findAll();
    }


    // Buscar por ID
    public Optional<Respostas> findById(Long id) {
        return respostaRepository.findById(id);
    }


    // Atualizar resposta
    public Respostas update(Long id, Respostas dadosAtualizados) {
        return respostaRepository.findById(id)
                .map(resposta -> {
                    resposta.setSimulacao(dadosAtualizados.getSimulacao());
                    resposta.setPergunta(dadosAtualizados.getPergunta());
                    resposta.setUrlAudio(dadosAtualizados.getUrlAudio());
                    resposta.setUrlVideo(dadosAtualizados.getUrlVideo());
                    resposta.setTranscricao(dadosAtualizados.getTranscricao());
                    return respostaRepository.save(resposta);
                })
                .orElseThrow(() -> new RuntimeException("Resposta não encontrada"));
    }


    // Deletar
    public void delete(Long id) {
        respostaRepository.deleteById(id);
    }
}
