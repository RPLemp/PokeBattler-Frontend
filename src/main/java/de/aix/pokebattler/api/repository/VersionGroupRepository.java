package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.game.VersionGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VersionGroupRepository extends JpaRepository<VersionGroup, Long> {
    Optional<VersionGroup> findByNameIgnoreCase(String name);
}
