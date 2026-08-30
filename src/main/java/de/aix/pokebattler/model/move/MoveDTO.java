package de.aix.pokebattler.model.move;

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
public class MoveDTO {
    @NotNull(message = "Move ID cannot be null")
    @Positive(message = "Move ID must be positive")
    private Long id;

    @NotBlank(message = "Move name cannot be empty")
    private String name;

    private Integer accuracy;
    private Integer effectChance;
    private Integer pp;
    private Integer priority;
    private Integer power;

    private Long contestTypeId;
    private Long contestEffectId;
    private Long superContestEffectId;
    private Long damageClassId;
    private Long generationId;
    private Long targetId;
    private Long typeId;
    private Long ailmentId;
    private Long categoryId;
    private List<Long> learnedByPokemonIds;
}
