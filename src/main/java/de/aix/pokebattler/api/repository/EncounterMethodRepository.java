package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.encounter.EncounterMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EncounterMethodRepository extends JpaRepository<EncounterMethod, Long> {
    Optional<EncounterMethod> findByNameIgnoreCase(String name);
}
