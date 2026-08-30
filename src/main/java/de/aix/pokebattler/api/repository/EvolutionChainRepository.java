package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.evolution.EvolutionChain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvolutionChainRepository extends JpaRepository<EvolutionChain, Long> {
}
