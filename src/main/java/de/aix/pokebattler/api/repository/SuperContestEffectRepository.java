package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.contest.SuperContestEffect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperContestEffectRepository extends JpaRepository<SuperContestEffect, Long> {
}
