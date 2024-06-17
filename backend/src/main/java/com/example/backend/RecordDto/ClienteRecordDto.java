package com.example.backend.RecordDto;

import jakarta.validation.constraints.NotBlank;

public record ClienteRecordDto(@NotBlank String emailCliente, @NotBlank String nomeCliente) {
}
