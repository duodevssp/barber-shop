package com.example.backend.Models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_CLIENTES")
public class ClienteModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCliente;
    private String emailCLiente;
    private String nomeCliente;

    public UUID getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(UUID idCliente) {
        this.idCliente = idCliente;
    }

    public String getEmailCLiente() {
        return emailCLiente;
    }

    public void setEmailCLiente(String emailCLiente) {
        this.emailCLiente = emailCLiente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}
