package com.example.backend.RecordDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

public record AgendamentoRecordDto( @NotNull UUID idCliente,
                                    @NotNull UUID idBarbeiro,
                                    @NotNull Date dataAgendamento) {
}
