package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.pokemon.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Long> {
    Optional<Gender> findByNameIgnoreCase(String name);
}
