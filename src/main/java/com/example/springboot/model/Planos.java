package com.example.springboot.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "planos")
@Data

public class Planos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column(name = "max_simulacoes_por_mes")
    private Integer maxSimulacoesPorMes;

    @Column(name = "permite_ia_avancada")
    private Boolean permiteIaAvancada;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
