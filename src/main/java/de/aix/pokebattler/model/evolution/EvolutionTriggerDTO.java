package de.aix.pokebattler.model.evolution;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvolutionTriggerDTO {
    @NotNull(message = "EvolutionTrigger ID cannot be null")
    @Positive(message = "EvolutionTrigger ID must be positive")
    private Long id;

    @NotBlank(message = "EvolutionTrigger name cannot be empty")
    private String name;

    private List<Long> pokemonSpeciesIds;
}
