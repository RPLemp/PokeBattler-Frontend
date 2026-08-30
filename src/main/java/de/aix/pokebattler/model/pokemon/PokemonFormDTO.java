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
public class PokemonFormDTO {
    @NotNull(message = "PokemonForm ID cannot be null")
    @Positive(message = "PokemonForm ID must be positive")
    private Long id;

    @NotBlank(message = "PokemonForm name cannot be empty")
    private String name;

    private Integer order;
    private Integer formOrder;
    private Boolean isDefault;
    private Boolean isBattleOnly;
    private Boolean isMega;
    private String formName;

    private Long pokemonId;
    private Long versionGroupId;
    private List<Long> typeIds;
}
