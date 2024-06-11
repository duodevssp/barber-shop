package com.example.backend.Repositories;

import com.example.backend.Models.BarbeiroModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BarbeiroRepository extends JpaRepository<BarbeiroModel, UUID> {
}
