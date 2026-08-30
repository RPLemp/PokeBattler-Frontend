package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.game.Generation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenerationRepository extends JpaRepository<Generation, Long> {
    Optional<Generation> findByNameIgnoreCase(String name);
}
