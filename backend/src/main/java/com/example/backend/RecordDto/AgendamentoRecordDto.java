package com.example.backend.RecordDto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record AgendamentoRecordDto(@NotBlank LocalDate data, @NotBlank LocalTime hora, @NotBlank String status, @NotBlank String tipoServico, @NotBlank
                                   UUID idCliente) {
}
