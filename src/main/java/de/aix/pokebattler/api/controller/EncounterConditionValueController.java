package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.EncounterConditionValueService;
import de.aix.pokebattler.model.encounter.EncounterConditionValueDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/encounter-condition-value")
@RequiredArgsConstructor
public class EncounterConditionValueController {
    private final EncounterConditionValueService encounterConditionValueService;

    @GetMapping
    public ResponseEntity<List<EncounterConditionValueDTO>> getAllEncounterConditionValues() {
        List<EncounterConditionValueDTO> items = encounterConditionValueService.getAllEncounterConditionValues();

        if (items.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EncounterConditionValueDTO> getEncounterConditionValueById(@PathVariable Long id) {
        return encounterConditionValueService.getEncounterConditionValueById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EncounterConditionValueDTO> createEncounterConditionValue(@Valid @RequestBody EncounterConditionValueDTO request) {
        EncounterConditionValueDTO created = encounterConditionValueService.createEncounterConditionValue(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EncounterConditionValueDTO> updateEncounterConditionValue(@PathVariable Long id, @Valid @RequestBody EncounterConditionValueDTO request) {
        return encounterConditionValueService.updateEncounterConditionValue(id, request)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEncounterConditionValue(@PathVariable Long id) {
        return encounterConditionValueService.deleteEncounterConditionValue(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
