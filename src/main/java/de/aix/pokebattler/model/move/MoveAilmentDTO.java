package de.aix.pokebattler.model.move;

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
public class MoveAilmentDTO {
    @NotNull(message = "MoveAilment ID cannot be null")
    @Positive(message = "MoveAilment ID must be positive")
    private Long id;

    @NotBlank(message = "MoveAilment name cannot be empty")
    private String name;

    private List<Long> moveIds;
}
