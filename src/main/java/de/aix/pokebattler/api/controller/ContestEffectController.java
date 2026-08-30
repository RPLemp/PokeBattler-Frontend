package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.ContestEffectService;
import de.aix.pokebattler.model.contest.ContestEffectDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/contest-effect")
@RequiredArgsConstructor
public class ContestEffectController {
    private final ContestEffectService contestEffectService;

    @GetMapping
    public ResponseEntity<List<ContestEffectDTO>> getAllContestEffects() {
        List<ContestEffectDTO> items = contestEffectService.getAllContestEffects();

        if (items.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContestEffectDTO> getContestEffectById(@PathVariable Long id) {
        return contestEffectService.getContestEffectById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ContestEffectDTO> createContestEffect(@Valid @RequestBody ContestEffectDTO request) {
        ContestEffectDTO created = contestEffectService.createContestEffect(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContestEffectDTO> updateContestEffect(@PathVariable Long id, @Valid @RequestBody ContestEffectDTO request) {
        return contestEffectService.updateContestEffect(id, request)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContestEffect(@PathVariable Long id) {
        return contestEffectService.deleteContestEffect(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
