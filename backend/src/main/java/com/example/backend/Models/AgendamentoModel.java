package com.example.backend.Models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "TB_AGENDAMENTO")
public class AgendamentoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idAgendamento;

    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    private ClienteModel cliente;

    @ManyToOne
    @JoinColumn(name = "idBarbeiro", referencedColumnName = "idBarbeiro")
    private BarbeiroModel barbeiro;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAgendamento;

    // Getters and Setters
    public UUID getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(UUID idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public BarbeiroModel getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(BarbeiroModel barbeiro) {
        this.barbeiro = barbeiro;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }
}
