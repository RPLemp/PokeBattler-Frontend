package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.BerryFlavorService;
import de.aix.pokebattler.model.berry.BerryFlavorDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/berry-flavor")
@RequiredArgsConstructor
public class BerryFlavorController {
    private final BerryFlavorService berryFlavorService;

    @GetMapping
    public ResponseEntity<List<BerryFlavorDTO>> getAllBerryFlavors() {
        List<BerryFlavorDTO> items = berryFlavorService.getAllBerryFlavors();

        if (items.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BerryFlavorDTO> getBerryFlavorById(@PathVariable Long id) {
        return berryFlavorService.getBerryFlavorById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BerryFlavorDTO> createBerryFlavor(@Valid @RequestBody BerryFlavorDTO request) {
        BerryFlavorDTO created = berryFlavorService.createBerryFlavor(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BerryFlavorDTO> updateBerryFlavor(@PathVariable Long id, @Valid @RequestBody BerryFlavorDTO request) {
        return berryFlavorService.updateBerryFlavor(id, request)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBerryFlavor(@PathVariable Long id) {
        return berryFlavorService.deleteBerryFlavor(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
