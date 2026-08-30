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
public class BerryFirmnessDTO {
    @NotNull(message = "BerryFirmness ID cannot be null")
    @Positive(message = "BerryFirmness ID must be positive")
    private Long id;

    @NotBlank(message = "BerryFirmness name cannot be empty")
    private String name;

    private List<Long> berryIds;
}
