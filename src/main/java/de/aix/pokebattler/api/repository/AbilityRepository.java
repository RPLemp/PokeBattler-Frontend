package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.pokemon.Ability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AbilityRepository extends JpaRepository<Ability, Long> {
    Optional<Ability> findByNameIgnoreCase(String name);
}
