package de.aix.pokebattler.model.game;

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
public class VersionDTO {
    @NotNull(message = "Version ID cannot be null")
    @Positive(message = "Version ID must be positive")
    private Long id;

    @NotBlank(message = "Version name cannot be empty")
    private String name;

    private Long versionGroupId;
}
