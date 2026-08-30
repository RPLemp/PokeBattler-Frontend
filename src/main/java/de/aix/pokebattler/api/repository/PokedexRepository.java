package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.game.Pokedex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokedexRepository extends JpaRepository<Pokedex, Long> {
    Optional<Pokedex> findByNameIgnoreCase(String name);
}
