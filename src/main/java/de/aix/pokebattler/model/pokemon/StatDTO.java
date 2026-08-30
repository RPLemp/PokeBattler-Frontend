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
public class StatDTO {
    @NotNull(message = "Stat ID cannot be null")
    @Positive(message = "Stat ID must be positive")
    private Long id;

    @NotBlank(message = "Stat name cannot be empty")
    private String name;

    private Integer gameIndex;
    private Boolean isBattleOnly;
    private Long moveDamageClassId;
    private List<Long> pokemonIds;
}
