package de.aix.pokebattler.model.contest;

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
public class ContestTypeDTO {
    @NotNull(message = "ContestType ID cannot be null")
    @Positive(message = "ContestType ID must be positive")
    private Long id;

    @NotBlank(message = "ContestType name cannot be empty")
    private String name;

    private Long berryFlavorId;
}
