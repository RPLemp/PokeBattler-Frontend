package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.ContestTypeService;
import de.aix.pokebattler.model.contest.ContestTypeDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/contest-type")
@RequiredArgsConstructor
public class ContestTypeController {
    private final ContestTypeService contestTypeService;

    @GetMapping
    public ResponseEntity<List<ContestTypeDTO>> getAllContestTypes() {
        List<ContestTypeDTO> items = contestTypeService.getAllContestTypes();

        if (items.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContestTypeDTO> getContestTypeById(@PathVariable Long id) {
        return contestTypeService.getContestTypeById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ContestTypeDTO> createContestType(@Valid @RequestBody ContestTypeDTO request) {
        ContestTypeDTO created = contestTypeService.createContestType(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContestTypeDTO> updateContestType(@PathVariable Long id, @Valid @RequestBody ContestTypeDTO request) {
        return contestTypeService.updateContestType(id, request)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContestType(@PathVariable Long id) {
        return contestTypeService.deleteContestType(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
