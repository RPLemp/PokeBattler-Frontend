package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.location.LocationArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationAreaRepository extends JpaRepository<LocationArea, Long> {
    Optional<LocationArea> findByNameIgnoreCase(String name);
}
