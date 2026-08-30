package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.pokemon.EggGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EggGroupRepository extends JpaRepository<EggGroup, Long> {
    Optional<EggGroup> findByNameIgnoreCase(String name);
}
