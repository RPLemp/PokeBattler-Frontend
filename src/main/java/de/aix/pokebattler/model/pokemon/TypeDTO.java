package de.aix.pokebattler.model.pokemon;

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
public class TypeDTO {
    @NotNull(message = "Type ID cannot be null")
    @Positive(message = "Type ID must be positive")
    private Long id;

    @NotBlank(message = "Type name cannot be empty")
    private String name;

    private Long generationId;
    private Long moveDamageClassId;
    private List<Long> pokemonIds;
    private List<Long> moveIds;
}
