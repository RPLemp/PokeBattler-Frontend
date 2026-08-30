package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.move.Move;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoveRepository extends JpaRepository<Move, Long> {
    Optional<Move> findByNameIgnoreCase(String name);
}
