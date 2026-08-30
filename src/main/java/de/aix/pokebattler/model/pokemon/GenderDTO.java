package de.aix.pokebattler.model.pokemon;

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
public class GenderDTO {
    @NotNull(message = "Gender ID cannot be null")
    @Positive(message = "Gender ID must be positive")
    private Long id;

    @NotBlank(message = "Gender name cannot be empty")
    private String name;

    private List<Long> pokemonSpeciesIds;
    private List<Long> requiredForEvolutionIds;
}
