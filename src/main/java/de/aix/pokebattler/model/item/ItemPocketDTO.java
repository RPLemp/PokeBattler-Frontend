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
public class ItemPocketDTO {
    @NotNull(message = "ItemPocket ID cannot be null")
    @Positive(message = "ItemPocket ID must be positive")
    private Long id;

    @NotBlank(message = "ItemPocket name cannot be empty")
    private String name;

    private List<Long> categoryIds;
}
