package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.move.MoveBattleStyle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoveBattleStyleRepository extends JpaRepository<MoveBattleStyle, Long> {
    Optional<MoveBattleStyle> findByNameIgnoreCase(String name);
}
