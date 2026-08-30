package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.move.MoveCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoveCategoryRepository extends JpaRepository<MoveCategory, Long> {
    Optional<MoveCategory> findByNameIgnoreCase(String name);
}
