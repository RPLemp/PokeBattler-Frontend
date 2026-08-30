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
public class ItemAttributeDTO {
    @NotNull(message = "ItemAttribute ID cannot be null")
    @Positive(message = "ItemAttribute ID must be positive")
    private Long id;

    @NotBlank(message = "ItemAttribute name cannot be empty")
    private String name;

    private List<Long> itemIds;
}
