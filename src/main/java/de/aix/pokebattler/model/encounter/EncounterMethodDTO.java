package de.aix.pokebattler.model.encounter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EncounterMethodDTO {
    @NotNull(message = "EncounterMethod ID cannot be null")
    @Positive(message = "EncounterMethod ID must be positive")
    private Long id;

    @NotBlank(message = "EncounterMethod name cannot be empty")
    private String name;

    private Integer order;
}
