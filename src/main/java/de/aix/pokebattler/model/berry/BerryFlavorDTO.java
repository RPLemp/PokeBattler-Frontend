package de.aix.pokebattler.model.berry;

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
public class BerryFlavorDTO {
    @NotNull(message = "BerryFlavor ID cannot be null")
    @Positive(message = "BerryFlavor ID must be positive")
    private Long id;

    @NotBlank(message = "BerryFlavor name cannot be empty")
    private String name;

    private Long contestTypeId;
    private List<Long> berryIds;
}
