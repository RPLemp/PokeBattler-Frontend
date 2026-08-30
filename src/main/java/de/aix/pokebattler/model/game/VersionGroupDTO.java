package de.aix.pokebattler.model.game;

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
public class VersionGroupDTO {
    @NotNull(message = "VersionGroup ID cannot be null")
    @Positive(message = "VersionGroup ID must be positive")
    private Long id;

    @NotBlank(message = "VersionGroup name cannot be empty")
    private String name;

    private Integer order;
    private Long generationId;
    private List<Long> moveLearnMethodIds;
    private List<Long> pokedexIds;
    private List<Long> regionIds;
    private List<Long> versionIds;
}
