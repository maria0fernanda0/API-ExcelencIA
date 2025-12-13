package com.example.springboot.services;

import com.example.springboot.model.Feedbacks;
import com.example.springboot.repository.FeedbacksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class FeedbackService {

    @Autowired
    private FeedbacksRepository feedbackRepository;


    // Criar feedback
    public Feedbacks create(Feedbacks feedback) {
        return feedbackRepository.save(feedback);
    }


    // Buscar todos
    public List<Feedbacks> findAll() {
        return feedbackRepository.findAll();
    }


    // Buscar por ID
    public Optional<Feedbacks> findById(Long id) {
        return feedbackRepository.findById(id);
    }


    // Atualizar feedback
    public Feedbacks update(Long id, Feedbacks dadosAtualizados) {
        return feedbackRepository.findById(id)
                .map(feedback -> {
                    feedback.setResposta(dadosAtualizados.getResposta());
                    feedback.setAnaliseVerbalNaoVerbal(dadosAtualizados.getAnaliseVerbalNaoVerbal());
                    feedback.setFeedbackTextoIa(dadosAtualizados.getFeedbackTextoIa());
                    feedback.setPontosFortes(dadosAtualizados.getPontosFortes());
                    feedback.setPontosAMelhorar(dadosAtualizados.getPontosAMelhorar());
                    feedback.setScoreResposta(dadosAtualizados.getScoreResposta());
                    return feedbackRepository.save(feedback);
                })
                .orElseThrow(() -> new RuntimeException("Feedback não encontrado"));
    }


    // Deletar
    public void delete(Long id) {
        feedbackRepository.deleteById(id);
    }
}
