package de.aix.pokebattler.model.currency;

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
public class CurrencyDTO {
    @NotNull(message = "Currency ID cannot be null")
    @Positive(message = "Currency ID must be positive")
    private Long id;

    @NotBlank(message = "Currency name cannot be empty")
    private String name;
}
