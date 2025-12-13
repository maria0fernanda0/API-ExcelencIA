package com.example.springboot.repository;

import com.example.springboot.model.Feedbacks;
import com.example.springboot.model.Respostas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FeedbacksRepository extends JpaRepository<Feedbacks, Long> {

    Feedbacks findByResposta(Respostas resposta);
}
