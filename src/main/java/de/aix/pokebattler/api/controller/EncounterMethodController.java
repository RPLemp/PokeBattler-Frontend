package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.EncounterMethodService;
import de.aix.pokebattler.model.encounter.EncounterMethodDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/encounter-method")
@RequiredArgsConstructor
public class EncounterMethodController {
    private final EncounterMethodService encounterMethodService;

    @GetMapping
    public ResponseEntity<List<EncounterMethodDTO>> getAllEncounterMethods() {
        List<EncounterMethodDTO> items = encounterMethodService.getAllEncounterMethods();

        if (items.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EncounterMethodDTO> getEncounterMethodById(@PathVariable Long id) {
        return encounterMethodService.getEncounterMethodById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EncounterMethodDTO> createEncounterMethod(@Valid @RequestBody EncounterMethodDTO request) {
        EncounterMethodDTO created = encounterMethodService.createEncounterMethod(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EncounterMethodDTO> updateEncounterMethod(@PathVariable Long id, @Valid @RequestBody EncounterMethodDTO request) {
        return encounterMethodService.updateEncounterMethod(id, request)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEncounterMethod(@PathVariable Long id) {
        return encounterMethodService.deleteEncounterMethod(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
