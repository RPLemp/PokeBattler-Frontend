package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.PalParkAreaService;
import de.aix.pokebattler.model.location.PalParkAreaDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pal-park-area")
@RequiredArgsConstructor
public class PalParkAreaController {
    private final PalParkAreaService palParkAreaService;

    @GetMapping
    public ResponseEntity<List<PalParkAreaDTO>> getAllPalParkAreas() {
        List<PalParkAreaDTO> items = palParkAreaService.getAllPalParkAreas();

        if (items.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PalParkAreaDTO> getPalParkAreaById(@PathVariable Long id) {
        return palParkAreaService.getPalParkAreaById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PalParkAreaDTO> createPalParkArea(@Valid @RequestBody PalParkAreaDTO request) {
        PalParkAreaDTO created = palParkAreaService.createPalParkArea(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PalParkAreaDTO> updatePalParkArea(@PathVariable Long id, @Valid @RequestBody PalParkAreaDTO request) {
        return palParkAreaService.updatePalParkArea(id, request)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePalParkArea(@PathVariable Long id) {
        return palParkAreaService.deletePalParkArea(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
