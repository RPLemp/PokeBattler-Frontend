package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.encounter.EncounterCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EncounterConditionRepository extends JpaRepository<EncounterCondition, Long> {
    Optional<EncounterCondition> findByNameIgnoreCase(String name);
}
