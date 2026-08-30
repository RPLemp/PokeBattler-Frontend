package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.pokemon.PokeathlonStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokeathlonStatRepository extends JpaRepository<PokeathlonStat, Long> {
    Optional<PokeathlonStat> findByNameIgnoreCase(String name);
}
