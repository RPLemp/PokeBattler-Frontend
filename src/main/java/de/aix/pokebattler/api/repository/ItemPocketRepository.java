package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.item.ItemPocket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemPocketRepository extends JpaRepository<ItemPocket, Long> {
    Optional<ItemPocket> findByNameIgnoreCase(String name);
}
