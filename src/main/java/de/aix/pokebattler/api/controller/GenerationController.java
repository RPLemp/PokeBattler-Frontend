package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.GenerationService;
import de.aix.pokebattler.model.game.GenerationDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/generation")
@RequiredArgsConstructor
public class GenerationController {
    private final GenerationService generationService;

    @GetMapping
    public ResponseEntity<List<GenerationDTO>> getAllGenerations() {
        List<GenerationDTO> items = generationService.getAllGenerations();

        if (items.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenerationDTO> getGenerationById(@PathVariable Long id) {
        return generationService.getGenerationById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GenerationDTO> createGeneration(@Valid @RequestBody GenerationDTO request) {
        GenerationDTO created = generationService.createGeneration(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenerationDTO> updateGeneration(@PathVariable Long id, @Valid @RequestBody GenerationDTO request) {
        return generationService.updateGeneration(id, request)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGeneration(@PathVariable Long id) {
        return generationService.deleteGeneration(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
