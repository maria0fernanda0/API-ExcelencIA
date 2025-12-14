package com.example.springboot.dto.simulacao;

public class ParametrosSimulacaoDTO {
    private String cargo;
    private String nivel;

    public ParametrosSimulacaoDTO() {
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
