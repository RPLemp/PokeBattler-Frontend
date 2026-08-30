package de.aix.pokebattler.model.encounter;

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
public class EncounterConditionDTO {
    @NotNull(message = "EncounterCondition ID cannot be null")
    @Positive(message = "EncounterCondition ID must be positive")
    private Long id;

    @NotBlank(message = "EncounterCondition name cannot be empty")
    private String name;

    private List<Long> valueIds;
}
