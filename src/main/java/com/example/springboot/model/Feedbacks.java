package com.example.springboot.model;


import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "feedbacks")
@Data
public class Feedbacks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "resposta_id", unique = true)
    private Respostas resposta;

    @Column(name = "analise_verbal_nao_verbal", columnDefinition = "jsonb")
    private String analiseVerbalNaoVerbal;

    @Column(name = "feedback_texto_ia")
    private String feedbackTextoIa;

    @Column(name = "pontos_fortes")
    private String pontosFortes;

    @Column(name = "pontos_a_melhorar")
    private String pontosAMelhorar;

    @Column(name = "score_resposta")
    private BigDecimal scoreResposta;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
