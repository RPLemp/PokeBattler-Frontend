package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.pokemon.PokemonShape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonShapeRepository extends JpaRepository<PokemonShape, Long> {
    Optional<PokemonShape> findByNameIgnoreCase(String name);
}
