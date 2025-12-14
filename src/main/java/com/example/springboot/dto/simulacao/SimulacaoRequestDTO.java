package com.example.springboot.dto.simulacao;

import java.time.LocalDateTime;

public class SimulacaoRequestDTO {

    private Integer usuarioId;
    private Integer cargoSimuladoId;
    private LocalDateTime dataHoraInicio;

    public SimulacaoRequestDTO() {
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getCargoSimuladoId() {
        return cargoSimuladoId;
    }

    public void setCargoSimuladoId(Integer cargoSimuladoId) {
        this.cargoSimuladoId = cargoSimuladoId;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }
}
