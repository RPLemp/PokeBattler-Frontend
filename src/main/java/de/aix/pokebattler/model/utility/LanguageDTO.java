package de.aix.pokebattler.model.utility;

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
public class LanguageDTO {
    @NotNull(message = "Language ID cannot be null")
    @Positive(message = "Language ID must be positive")
    private Long id;

    @NotBlank(message = "Language name cannot be empty")
    private String name;

    private Boolean official;
    private String iso639;
    private String iso3166;
}
