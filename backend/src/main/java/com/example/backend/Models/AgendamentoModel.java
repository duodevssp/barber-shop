package com.example.backend.Models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "TB_AGENDAMENTO")
public class AgendamentoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idAgendamento;

    private LocalDate data;
    private LocalTime hora;
    private String status;
    private String tipoServico;
    private UUID idCliente;

    public UUID getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(UUID idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public UUID getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(UUID idCliente) {
        this.idCliente = idCliente;
    }

    public UUID getIdBarbeiro() {
        return idBarbeiro;
    }

    public void setIdBarbeiro(UUID idBarbeiro) {
        this.idBarbeiro = idBarbeiro;
    }

    private UUID idBarbeiro;


}
