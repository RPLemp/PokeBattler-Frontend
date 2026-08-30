package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.pokemon.Stat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatRepository extends JpaRepository<Stat, Long> {
    Optional<Stat> findByNameIgnoreCase(String name);
}
