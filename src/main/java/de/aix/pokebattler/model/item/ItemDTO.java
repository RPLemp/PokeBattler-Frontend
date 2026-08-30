package de.aix.pokebattler.model.item;

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
public class ItemDTO {
    @NotNull(message = "Item ID cannot be null")
    @Positive(message = "Item ID must be positive")
    private Long id;

    @NotBlank(message = "Item name cannot be empty")
    private String name;

    private Integer cost;
    private Integer flingPower;
    private Long flingEffectId;
    private List<Long> attributeIds;
    private Long categoryId;
    private Long babyTriggerForId;
}
