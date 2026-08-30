package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.location.PalParkArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PalParkAreaRepository extends JpaRepository<PalParkArea, Long> {
    Optional<PalParkArea> findByNameIgnoreCase(String name);
}
