package de.aix.pokebattler.model.game;

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
public class GenerationDTO {
    @NotNull(message = "Generation ID cannot be null")
    @Positive(message = "Generation ID must be positive")
    private Long id;

    @NotBlank(message = "Generation name cannot be empty")
    private String name;

    private Long mainRegionId;
    private List<Long> abilityIds;
    private List<Long> moveIds;
    private List<Long> pokemonSpeciesIds;
    private List<Long> typeIds;
    private List<Long> versionGroupIds;
}
