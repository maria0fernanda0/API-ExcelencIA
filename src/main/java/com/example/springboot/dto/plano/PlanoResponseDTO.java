package com.example.springboot.dto.plano;

public class PlanoResponseDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private Integer maxSimulacoesPorMes;
    private Boolean permiteIaAvancada;

    public PlanoResponseDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getMaxSimulacoesPorMes() {
        return maxSimulacoesPorMes;
    }

    public void setMaxSimulacoesPorMes(Integer maxSimulacoesPorMes) {
        this.maxSimulacoesPorMes = maxSimulacoesPorMes;
    }

    public Boolean getPermiteIaAvancada() {
        return permiteIaAvancada;
    }

    public void setPermiteIaAvancada(Boolean permiteIaAvancada) {
        this.permiteIaAvancada = permiteIaAvancada;
    }

}
