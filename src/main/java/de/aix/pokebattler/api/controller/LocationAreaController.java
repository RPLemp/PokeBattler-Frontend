package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.LocationAreaService;
import de.aix.pokebattler.model.location.LocationAreaDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/location-area")
@RequiredArgsConstructor
public class LocationAreaController {
    private final LocationAreaService locationAreaService;

    @GetMapping
    public ResponseEntity<List<LocationAreaDTO>> getAllLocationAreas() {
        List<LocationAreaDTO> items = locationAreaService.getAllLocationAreas();

        if (items.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationAreaDTO> getLocationAreaById(@PathVariable Long id) {
        return locationAreaService.getLocationAreaById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LocationAreaDTO> createLocationArea(@Valid @RequestBody LocationAreaDTO request) {
        LocationAreaDTO created = locationAreaService.createLocationArea(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocationAreaDTO> updateLocationArea(@PathVariable Long id, @Valid @RequestBody LocationAreaDTO request) {
        return locationAreaService.updateLocationArea(id, request)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocationArea(@PathVariable Long id) {
        return locationAreaService.deleteLocationArea(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
