package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.berry.BerryFirmness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BerryFirmnessRepository extends JpaRepository<BerryFirmness, Long> {
    Optional<BerryFirmness> findByNameIgnoreCase(String name);
}
