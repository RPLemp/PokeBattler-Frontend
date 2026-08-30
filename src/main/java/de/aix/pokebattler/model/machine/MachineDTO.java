package de.aix.pokebattler.model.machine;

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
public class MachineDTO {
    @NotNull(message = "Machine ID cannot be null")
    @Positive(message = "Machine ID must be positive")
    private Long id;

    private Long itemId;
    private Long moveId;
    private Long versionGroupId;
}
