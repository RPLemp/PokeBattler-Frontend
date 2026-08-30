package de.aix.pokebattler.model.location;

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
public class PalParkAreaDTO {
    @NotNull(message = "PalParkArea ID cannot be null")
    @Positive(message = "PalParkArea ID must be positive")
    private Long id;

    @NotBlank(message = "PalParkArea name cannot be empty")
    private String name;

    private List<Long> pokemonSpeciesIds;
}
