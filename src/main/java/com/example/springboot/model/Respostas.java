package com.example.springboot.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "respostas")
@Data
public class Respostas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "simulacao_id")
    private Simulacoes simulacao;

    @ManyToOne
    @JoinColumn(name = "pergunta_id")
    private Perguntas pergunta;

    @Column(name = "url_audio")
    private String urlAudio;

    @Column(name = "url_video")
    private String urlVideo;

    private String transcricao;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
