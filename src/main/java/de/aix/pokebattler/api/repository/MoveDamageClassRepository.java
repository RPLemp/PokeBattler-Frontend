package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.move.MoveDamageClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoveDamageClassRepository extends JpaRepository<MoveDamageClass, Long> {
    Optional<MoveDamageClass> findByNameIgnoreCase(String name);
}
