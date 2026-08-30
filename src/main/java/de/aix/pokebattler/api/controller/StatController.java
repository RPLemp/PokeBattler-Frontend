package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.StatService;
import de.aix.pokebattler.model.pokemon.StatDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/stat")
public class StatController {
    private final StatService statService;

    public StatController(StatService statService) {
        this.statService = statService;
    }

    @GetMapping
    public ResponseEntity<List<StatDTO>> getAllStats() {
        return ResponseEntity.ok(statService.getAllStats());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatDTO> getStatById(@PathVariable Long id) {
        return statService.getStatById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<StatDTO> getStatByName(@PathVariable String name) {
        return statService.getStatByName(name)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
