package com.example.springboot.dto.feedback;

public class FeedbackResponseDTO {

    private Integer id;
    private Integer respostaId;
    private String feedbackTextoIa;
    private String pontosFortes;
    private String pontosAMelhorar;
    private Double scoreResposta;

    public FeedbackResponseDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRespostaId() {
        return respostaId;
    }

    public void setRespostaId(Integer respostaId) {
        this.respostaId = respostaId;
    }

    public String getFeedbackTextoIa() {
        return feedbackTextoIa;
    }

    public void setFeedbackTextoIa(String feedbackTextoIa) {
        this.feedbackTextoIa = feedbackTextoIa;
    }

    public String getPontosFortes() {
        return pontosFortes;
    }

    public void setPontosFortes(String pontosFortes) {
        this.pontosFortes = pontosFortes;
    }

    public String getPontosAMelhorar() {
        return pontosAMelhorar;
    }

    public void setPontosAMelhorar(String pontosAMelhorar) {
        this.pontosAMelhorar = pontosAMelhorar;
    }

    public Double getScoreResposta() {
        return scoreResposta;
    }

    public void setScoreResposta(Double scoreResposta) {
        this.scoreResposta = scoreResposta;
    }

}
