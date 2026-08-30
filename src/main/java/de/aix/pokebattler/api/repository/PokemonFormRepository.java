package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.pokemon.PokemonForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonFormRepository extends JpaRepository<PokemonForm, Long> {
    Optional<PokemonForm> findByNameIgnoreCase(String name);
}
