package com.example.springboot.repository;

import com.example.springboot.model.Progresso;
import com.example.springboot.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProgressoRepository extends JpaRepository<Progresso, Long> {

    Progresso findByUsuario(Usuario usuario);
}
