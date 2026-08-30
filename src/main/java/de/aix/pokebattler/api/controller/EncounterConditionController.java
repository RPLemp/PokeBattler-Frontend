package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.EncounterConditionService;
import de.aix.pokebattler.model.encounter.EncounterConditionDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/encounter-condition")
@RequiredArgsConstructor
public class EncounterConditionController {
    private final EncounterConditionService encounterConditionService;

    @GetMapping
    public ResponseEntity<List<EncounterConditionDTO>> getAllEncounterConditions() {
        List<EncounterConditionDTO> items = encounterConditionService.getAllEncounterConditions();

        if (items.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EncounterConditionDTO> getEncounterConditionById(@PathVariable Long id) {
        return encounterConditionService.getEncounterConditionById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EncounterConditionDTO> createEncounterCondition(@Valid @RequestBody EncounterConditionDTO request) {
        EncounterConditionDTO created = encounterConditionService.createEncounterCondition(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EncounterConditionDTO> updateEncounterCondition(@PathVariable Long id, @Valid @RequestBody EncounterConditionDTO request) {
        return encounterConditionService.updateEncounterCondition(id, request)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEncounterCondition(@PathVariable Long id) {
        return encounterConditionService.deleteEncounterCondition(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
