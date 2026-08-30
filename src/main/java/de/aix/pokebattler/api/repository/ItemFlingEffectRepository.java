package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.item.ItemFlingEffect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemFlingEffectRepository extends JpaRepository<ItemFlingEffect, Long> {
    Optional<ItemFlingEffect> findByNameIgnoreCase(String name);
}
