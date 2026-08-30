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
public class ItemCategoryDTO {
    @NotNull(message = "ItemCategory ID cannot be null")
    @Positive(message = "ItemCategory ID must be positive")
    private Long id;

    @NotBlank(message = "ItemCategory name cannot be empty")
    private String name;

    private Long pocketId;
    private List<Long> itemIds;
}
