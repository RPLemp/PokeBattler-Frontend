package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.EvolutionTriggerService;
import de.aix.pokebattler.model.evolution.EvolutionTriggerDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/evolution-trigger")
@RequiredArgsConstructor
public class EvolutionTriggerController {
    private final EvolutionTriggerService evolutionTriggerService;

    @GetMapping
    public ResponseEntity<List<EvolutionTriggerDTO>> getAllEvolutionTriggers() {
        List<EvolutionTriggerDTO> items = evolutionTriggerService.getAllEvolutionTriggers();

        if (items.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvolutionTriggerDTO> getEvolutionTriggerById(@PathVariable Long id) {
        return evolutionTriggerService.getEvolutionTriggerById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EvolutionTriggerDTO> createEvolutionTrigger(@Valid @RequestBody EvolutionTriggerDTO request) {
        EvolutionTriggerDTO created = evolutionTriggerService.createEvolutionTrigger(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EvolutionTriggerDTO> updateEvolutionTrigger(@PathVariable Long id, @Valid @RequestBody EvolutionTriggerDTO request) {
        return evolutionTriggerService.updateEvolutionTrigger(id, request)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvolutionTrigger(@PathVariable Long id) {
        return evolutionTriggerService.deleteEvolutionTrigger(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
