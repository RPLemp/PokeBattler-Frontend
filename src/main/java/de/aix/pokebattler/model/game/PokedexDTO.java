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
public class PokedexDTO {
    @NotNull(message = "Pokedex ID cannot be null")
    @Positive(message = "Pokedex ID must be positive")
    private Long id;

    @NotBlank(message = "Pokedex name cannot be empty")
    private String name;

    private Boolean isMainSeries;
    private Long regionId;
    private List<Long> versionGroupIds;
    private List<Long> pokemonSpeciesIds;
}
