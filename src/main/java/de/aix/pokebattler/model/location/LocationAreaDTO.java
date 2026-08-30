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
public class LocationAreaDTO {
    @NotNull(message = "LocationArea ID cannot be null")
    @Positive(message = "LocationArea ID must be positive")
    private Long id;

    @NotBlank(message = "LocationArea name cannot be empty")
    private String name;

    private Integer gameIndex;
    private Long locationId;
    private List<Long> pokemonEncounterIds;
}
