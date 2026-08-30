package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.VersionService;
import de.aix.pokebattler.model.game.VersionDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/version")
@RequiredArgsConstructor
public class VersionController {
    private final VersionService versionService;

    @GetMapping
    public ResponseEntity<List<VersionDTO>> getAllVersions() {
        List<VersionDTO> items = versionService.getAllVersions();

        if (items.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VersionDTO> getVersionById(@PathVariable Long id) {
        return versionService.getVersionById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<VersionDTO> createVersion(@Valid @RequestBody VersionDTO request) {
        VersionDTO created = versionService.createVersion(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VersionDTO> updateVersion(@PathVariable Long id, @Valid @RequestBody VersionDTO request) {
        return versionService.updateVersion(id, request)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVersion(@PathVariable Long id) {
        return versionService.deleteVersion(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
