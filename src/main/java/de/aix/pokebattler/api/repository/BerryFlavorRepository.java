package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.berry.BerryFlavor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BerryFlavorRepository extends JpaRepository<BerryFlavor, Long> {
    Optional<BerryFlavor> findByNameIgnoreCase(String name);
}
