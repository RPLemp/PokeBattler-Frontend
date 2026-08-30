package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.VersionGroupService;
import de.aix.pokebattler.model.game.VersionGroupDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/version-group")
@RequiredArgsConstructor
public class VersionGroupController {
    private final VersionGroupService versionGroupService;

    @GetMapping
    public ResponseEntity<List<VersionGroupDTO>> getAllVersionGroups() {
        List<VersionGroupDTO> items = versionGroupService.getAllVersionGroups();

        if (items.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VersionGroupDTO> getVersionGroupById(@PathVariable Long id) {
        return versionGroupService.getVersionGroupById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<VersionGroupDTO> createVersionGroup(@Valid @RequestBody VersionGroupDTO request) {
        VersionGroupDTO created = versionGroupService.createVersionGroup(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VersionGroupDTO> updateVersionGroup(@PathVariable Long id, @Valid @RequestBody VersionGroupDTO request) {
        return versionGroupService.updateVersionGroup(id, request)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVersionGroup(@PathVariable Long id) {
        return versionGroupService.deleteVersionGroup(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
