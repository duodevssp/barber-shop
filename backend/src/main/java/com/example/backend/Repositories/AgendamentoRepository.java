package com.example.backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AgendamentoRepository extends JpaRepository<AgendamentoRepository, UUID> {
}
