package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.SuperContestEffectService;
import de.aix.pokebattler.model.contest.SuperContestEffectDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/super-contest-effect")
@RequiredArgsConstructor
public class SuperContestEffectController {
    private final SuperContestEffectService superContestEffectService;

    @GetMapping
    public ResponseEntity<List<SuperContestEffectDTO>> getAllSuperContestEffects() {
        List<SuperContestEffectDTO> items = superContestEffectService.getAllSuperContestEffects();

        if (items.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuperContestEffectDTO> getSuperContestEffectById(@PathVariable Long id) {
        return superContestEffectService.getSuperContestEffectById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SuperContestEffectDTO> createSuperContestEffect(@Valid @RequestBody SuperContestEffectDTO request) {
        SuperContestEffectDTO created = superContestEffectService.createSuperContestEffect(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuperContestEffectDTO> updateSuperContestEffect(@PathVariable Long id, @Valid @RequestBody SuperContestEffectDTO request) {
        return superContestEffectService.updateSuperContestEffect(id, request)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSuperContestEffect(@PathVariable Long id) {
        return superContestEffectService.deleteSuperContestEffect(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
