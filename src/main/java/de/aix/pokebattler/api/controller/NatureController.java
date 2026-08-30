package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.NatureService;
import de.aix.pokebattler.model.pokemon.NatureDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/nature")
public class NatureController {
    private final NatureService natureService;

    public NatureController(NatureService natureService) {
        this.natureService = natureService;
    }

    @GetMapping
    public ResponseEntity<List<NatureDTO>> getAllNatures() {
        return ResponseEntity.ok(natureService.getAllNatures());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NatureDTO> getNatureById(@PathVariable Long id) {
        return natureService.getNatureById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<NatureDTO> getNatureByName(@PathVariable String name) {
        return natureService.getNatureByName(name)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
