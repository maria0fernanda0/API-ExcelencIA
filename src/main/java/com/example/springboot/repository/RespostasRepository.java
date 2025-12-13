package com.example.springboot.repository;

import com.example.springboot.model.Respostas;
import com.example.springboot.model.Simulacoes;
import com.example.springboot.model.Perguntas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface RespostasRepository extends  JpaRepository<Respostas, Long> {

    List<Respostas> findBySimulacao(Simulacoes simulacao);

    List<Respostas> findByPergunta(Perguntas pergunta);

}
