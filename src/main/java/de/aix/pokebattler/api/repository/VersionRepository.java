package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.game.Version;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VersionRepository extends JpaRepository<Version, Long> {
    Optional<Version> findByNameIgnoreCase(String name);
}
