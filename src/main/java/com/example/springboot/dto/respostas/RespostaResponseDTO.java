package com.example.springboot.dto.respostas;

public class RespostaResponseDTO {

    private Integer id;
    private Integer simulacaoId;
    private Integer perguntaId;
    private String transcricao;

    public RespostaResponseDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSimulacaoId() {
        return simulacaoId;
    }

    public void setSimulacaoId(Integer simulacaoId) {
        this.simulacaoId = simulacaoId;
    }

    public Integer getPerguntaId() {
        return perguntaId;
    }

    public void setPerguntaId(Integer perguntaId) {
        this.perguntaId = perguntaId;
    }

    public String getTranscricao() {
        return transcricao;
    }

    public void setTranscricao(String transcricao) {
        this.transcricao = transcricao;
    }

}
