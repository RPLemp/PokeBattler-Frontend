package de.aix.pokebattler.model.pokemon;

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
public class CharacteristicDTO {
    @NotNull(message = "Characteristic ID cannot be null")
    @Positive(message = "Characteristic ID must be positive")
    private Long id;

    private Integer geneModulo;
    private Long highestStatId;
}
