package de.aix.pokebattler.model.move;

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
public class MoveBattleStyleDTO {
    @NotNull(message = "MoveBattleStyle ID cannot be null")
    @Positive(message = "MoveBattleStyle ID must be positive")
    private Long id;

    @NotBlank(message = "MoveBattleStyle name cannot be empty")
    private String name;
}
