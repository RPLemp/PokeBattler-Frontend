package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.contest.ContestType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContestTypeRepository extends JpaRepository<ContestType, Long> {
    Optional<ContestType> findByNameIgnoreCase(String name);
}
