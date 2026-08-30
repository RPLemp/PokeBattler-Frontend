package de.aix.pokebattler.model.evolution;

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
public class EvolutionChainDTO {
    @NotNull(message = "EvolutionChain ID cannot be null")
    @Positive(message = "EvolutionChain ID must be positive")
    private Long id;

    private Long babyTriggerItemId;
}
