package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.item.ItemAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemAttributeRepository extends JpaRepository<ItemAttribute, Long> {
    Optional<ItemAttribute> findByNameIgnoreCase(String name);
}
