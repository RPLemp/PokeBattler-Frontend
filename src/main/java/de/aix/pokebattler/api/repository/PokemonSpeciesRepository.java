package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.pokemon.PokemonSpecies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonSpeciesRepository extends JpaRepository<PokemonSpecies, Long> {
    Optional<PokemonSpecies> findByNameIgnoreCase(String name);
}
