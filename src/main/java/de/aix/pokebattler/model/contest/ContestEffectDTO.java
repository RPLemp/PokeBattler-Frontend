package de.aix.pokebattler.model.contest;

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
public class ContestEffectDTO {
    @NotNull(message = "ContestEffect ID cannot be null")
    @Positive(message = "ContestEffect ID must be positive")
    private Long id;

    private Integer appeal;
    private Integer jam;
    private String effect;
    private String flavorText;
}
