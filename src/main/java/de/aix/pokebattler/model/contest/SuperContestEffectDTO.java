package de.aix.pokebattler.model.contest;

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
public class SuperContestEffectDTO {
    @NotNull(message = "SuperContestEffect ID cannot be null")
    @Positive(message = "SuperContestEffect ID must be positive")
    private Long id;

    private Integer appeal;
    private String flavorText;
    private List<Long> moveIds;
}
