package de.aix.pokebattler.model.encounter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EncounterConditionValueDTO {
    @NotNull(message = "EncounterConditionValue ID cannot be null")
    @Positive(message = "EncounterConditionValue ID must be positive")
    private Long id;

    @NotBlank(message = "EncounterConditionValue name cannot be empty")
    private String name;

    private Long conditionId;
}
