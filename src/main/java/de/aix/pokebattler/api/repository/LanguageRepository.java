package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.utility.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
    Optional<Language> findByNameIgnoreCase(String name);
}
