package com.example.backend.Models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_BARBEIROS")
public class BarbeiroModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idBarbeiro;
    private String nomeBarbeiro;
    private String emailBarbeiro;
    private char especialidade;

    public UUID getIdBarbeiro(){
        return idBarbeiro;
    }

    public void setIdBarbeiro(UUID idBarbeiro){
        this.idBarbeiro = idBarbeiro;
    }

    public String getNomeBarbeiro() {
        return nomeBarbeiro;
    }

    public void setNomeBarbeiro(String nomeBarbeiro) {
        this.nomeBarbeiro = nomeBarbeiro;
    }

    public String getEmailBarbeiro() {
        return emailBarbeiro;
    }

    public void setEmailBarbeiro(String emailBarbeiro) {
        this.emailBarbeiro = emailBarbeiro;
    }

    public char getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(char especialidade) {
        this.especialidade = especialidade;
    }

}
