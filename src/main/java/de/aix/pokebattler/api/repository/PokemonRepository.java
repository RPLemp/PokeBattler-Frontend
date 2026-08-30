package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.pokemon.Pokemon;
import jakarta.validation.constraints.NotBlank;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Optional<Pokemon> findByNameIgnoreCase(@NotBlank String name);
    boolean existsById(@NonNull Long id);
}
