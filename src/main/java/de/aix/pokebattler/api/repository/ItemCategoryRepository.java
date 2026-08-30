package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.item.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Long> {
    Optional<ItemCategory> findByNameIgnoreCase(String name);
}
