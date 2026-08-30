package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.evolution.EvolutionTrigger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EvolutionTriggerRepository extends JpaRepository<EvolutionTrigger, Long> {
    Optional<EvolutionTrigger> findByNameIgnoreCase(String name);
}
