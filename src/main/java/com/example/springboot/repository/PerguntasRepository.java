package com.example.springboot.repository;

import com.example.springboot.model.Perguntas;
import com.example.springboot.model.CargoUsuario;
import com.example.springboot.model.NivelDificuldadeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PerguntasRepository extends JpaRepository<Perguntas,Long> {

    List<Perguntas> findByCargo(CargoUsuario cargo);

    List<Perguntas> findByNivelDificuldade(NivelDificuldadeEnum dificuldade);

}
