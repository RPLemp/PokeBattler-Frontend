package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.pokemon.PokemonHabitat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonHabitatRepository extends JpaRepository<PokemonHabitat, Long> {
    Optional<PokemonHabitat> findByNameIgnoreCase(String name);
}
