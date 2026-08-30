package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.move.MoveTarget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoveTargetRepository extends JpaRepository<MoveTarget, Long> {
    Optional<MoveTarget> findByNameIgnoreCase(String name);
}
