package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.contest.ContestEffect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContestEffectRepository extends JpaRepository<ContestEffect, Long> {
}
