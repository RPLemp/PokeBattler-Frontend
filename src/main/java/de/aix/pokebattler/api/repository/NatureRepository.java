package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.pokemon.Nature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NatureRepository extends JpaRepository<Nature, Long> {
    Optional<Nature> findByNameIgnoreCase(String name);
}
