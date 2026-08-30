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
public class PokemonSpeciesDTO {
    @NotNull(message = "PokemonSpecies ID cannot be null")
    @Positive(message = "PokemonSpecies ID must be positive")
    private Long id;

    @NotBlank(message = "PokemonSpecies name cannot be empty")
    private String name;

    private Integer order;
    private Integer genderRate;
    private Integer captureRate;
    private Integer baseHappiness;
    private Boolean isBaby;
    private Boolean isLegendary;
    private Boolean isMythical;
    private Integer hatchCounter;
    private Boolean hasGenderDifferences;
    private Boolean formsSwitchable;

    private Long growthRateId;
    private Long colorId;
    private Long shapeId;
    private Long evolvesFromSpeciesId;
    private Long evolutionChainId;
    private Long habitatId;
    private Long generationId;
    private List<Long> eggGroupIds;
    private List<Long> pokedexIds;
    private List<Long> varietyPokemonIds;
}
