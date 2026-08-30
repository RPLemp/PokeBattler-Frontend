package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.pokemon.GrowthRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GrowthRateRepository extends JpaRepository<GrowthRate, Long> {
    Optional<GrowthRate> findByNameIgnoreCase(String name);
}
