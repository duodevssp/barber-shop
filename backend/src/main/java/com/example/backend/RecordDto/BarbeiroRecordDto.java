package com.example.backend.RecordDto;

import jakarta.validation.constraints.NotBlank;

public record BarbeiroRecordDto(@NotBlank String nomeBarbeiro, @NotBlank String emailBarbeiro, @NotBlank char especialidade) {
}
