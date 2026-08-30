package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.CurrencyService;
import de.aix.pokebattler.model.currency.CurrencyDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/currency")
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyService currencyService;

    @GetMapping
    public ResponseEntity<List<CurrencyDTO>> getAllCurrencies() {
        List<CurrencyDTO> items = currencyService.getAllCurrencies();

        if (items.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CurrencyDTO> getCurrencyById(@PathVariable Long id) {
        return currencyService.getCurrencyById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CurrencyDTO> createCurrency(@Valid @RequestBody CurrencyDTO request) {
        CurrencyDTO created = currencyService.createCurrency(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CurrencyDTO> updateCurrency(@PathVariable Long id, @Valid @RequestBody CurrencyDTO request) {
        return currencyService.updateCurrency(id, request)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurrency(@PathVariable Long id) {
        return currencyService.deleteCurrency(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
