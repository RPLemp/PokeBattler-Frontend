package de.aix.pokebattler.model.pokemon;

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
public class NatureDTO {
    @NotNull(message = "Nature ID cannot be null")
    @Positive(message = "Nature ID must be positive")
    private Long id;

    @NotBlank(message = "Nature name cannot be empty")
    private String name;

    private Long decreasedStatId;
    private Long increasedStatId;
    private Long hatesFlavorId;
    private Long likesFlavorId;
    private Long pokeathlonStatId;
}
