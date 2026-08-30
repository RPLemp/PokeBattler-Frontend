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
public class PokemonDTO {
    @NotNull(message = "Pokemon ID cannot be null")
    @Positive(message = "Pokemon ID must be positive")
    private Long id;

    @NotBlank(message = "Pokemon name cannot be empty")
    private String name;

    private Integer baseExperience;
    private Integer height;
    private Boolean isDefault;
    private Integer order;
    private Integer weight;

    private Long speciesId;
    private List<Long> abilityIds;
    private List<Long> typeIds;
    private List<Long> formIds;
    private List<Long> moveIds;
    private List<Long> statIds;
    private List<Long> heldItemIds;

    public PokemonDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
