package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.EvolutionChainService;
import de.aix.pokebattler.model.evolution.EvolutionChainDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/evolution-chain")
@RequiredArgsConstructor
public class EvolutionChainController {
    private final EvolutionChainService evolutionChainService;

    @GetMapping
    public ResponseEntity<List<EvolutionChainDTO>> getAllEvolutionChains() {

        List<EvolutionChainDTO> items = evolutionChainService.getAllEvolutionChains();
        if (items.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvolutionChainDTO> getEvolutionChainById(@PathVariable Long id) {
        return evolutionChainService.getEvolutionChainById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EvolutionChainDTO> createEvolutionChain(@Valid @RequestBody EvolutionChainDTO request) {
        EvolutionChainDTO created = evolutionChainService.createEvolutionChain(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EvolutionChainDTO> updateEvolutionChain(@PathVariable Long id, @Valid @RequestBody EvolutionChainDTO request) {
        return evolutionChainService.updateEvolutionChain(id, request)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvolutionChain(@PathVariable Long id) {
        return evolutionChainService.deleteEvolutionChain(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
