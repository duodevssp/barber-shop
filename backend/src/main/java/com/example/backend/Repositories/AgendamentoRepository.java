package com.example.backend.Repositories;

import com.example.backend.Models.AgendamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AgendamentoRepository extends JpaRepository<AgendamentoModel, UUID> {
}
