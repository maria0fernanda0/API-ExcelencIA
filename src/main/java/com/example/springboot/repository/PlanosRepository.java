package com.example.springboot.repository;

import com.example.springboot.model.Planos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PlanosRepository extends JpaRepository<Planos,Long> {
}
