package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.pokemon.PokemonColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonColorRepository extends JpaRepository<PokemonColor, Long> {
    Optional<PokemonColor> findByNameIgnoreCase(String name);
}
