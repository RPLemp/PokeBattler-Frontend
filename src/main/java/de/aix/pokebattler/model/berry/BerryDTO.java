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
public class BerryDTO {
    @NotNull(message = "Berry ID cannot be null")
    @Positive(message = "Berry ID must be positive")
    private Long id;

    @NotBlank(message = "Berry name cannot be empty")
    private String name;

    private Integer growthTime;
    private Integer maxHarvest;
    private Integer naturalGiftPower;
    private Integer size;
    private Integer smoothness;
    private Integer soilDryness;

    private Long firmnessId;
    private Long itemId;
    private Long naturalGiftTypeId;
    private List<Long> flavorIds;
}
