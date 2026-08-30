package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.move.MoveLearnMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoveLearnMethodRepository extends JpaRepository<MoveLearnMethod, Long> {
    Optional<MoveLearnMethod> findByNameIgnoreCase(String name);
}
