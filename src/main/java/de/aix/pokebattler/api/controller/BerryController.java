package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.BerryService;
import de.aix.pokebattler.model.berry.BerryDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/berry")
@RequiredArgsConstructor
public class BerryController {
    private final BerryService berryService;

    @GetMapping
    public ResponseEntity<List<BerryDTO>> getAllBerries() {
        List<BerryDTO> items = berryService.getAllBerries();

        if (items.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BerryDTO> getBerryById(@PathVariable Long id) {
        return berryService.getBerryById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BerryDTO> createBerry(@Valid @RequestBody BerryDTO request) {
        BerryDTO created = berryService.createBerry(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BerryDTO> updateBerry(@PathVariable Long id, @Valid @RequestBody BerryDTO request) {
        return berryService.updateBerry(id, request)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBerry(@PathVariable Long id) {
        return berryService.deleteBerry(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
