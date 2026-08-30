package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.berry.Berry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BerryRepository extends JpaRepository<Berry, Long> {
    Optional<Berry> findByNameIgnoreCase(String name);
}
