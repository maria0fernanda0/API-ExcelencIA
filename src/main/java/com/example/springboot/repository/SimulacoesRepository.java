package com.example.springboot.repository;


import com.example.springboot.model.Simulacoes;
import com.example.springboot.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface SimulacoesRepository extends  JpaRepository<Simulacoes, Long> {

    List<Simulacoes> findByUsuario(Usuario usuario);
}
