package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.BerryFirmnessService;
import de.aix.pokebattler.model.berry.BerryFirmnessDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/berry-firmness")
@RequiredArgsConstructor
public class BerryFirmnessController {
    private final BerryFirmnessService berryFirmnessService;

    @GetMapping
    public ResponseEntity<List<BerryFirmnessDTO>> getAllBerryFirmnesses() {
        List<BerryFirmnessDTO> items = berryFirmnessService.getAllBerryFirmnesses();

        if (items.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BerryFirmnessDTO> getBerryFirmnessById(@PathVariable Long id) {
        return berryFirmnessService.getBerryFirmnessById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BerryFirmnessDTO> createBerryFirmness(@Valid @RequestBody BerryFirmnessDTO request) {
        BerryFirmnessDTO created = berryFirmnessService.createBerryFirmness(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BerryFirmnessDTO> updateBerryFirmness(@PathVariable Long id, @Valid @RequestBody BerryFirmnessDTO request) {
        return berryFirmnessService.updateBerryFirmness(id, request)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBerryFirmness(@PathVariable Long id) {
        return berryFirmnessService.deleteBerryFirmness(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
