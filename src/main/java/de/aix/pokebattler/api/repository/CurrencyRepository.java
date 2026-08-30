package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.currency.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Optional<Currency> findByNameIgnoreCase(String name);
}
