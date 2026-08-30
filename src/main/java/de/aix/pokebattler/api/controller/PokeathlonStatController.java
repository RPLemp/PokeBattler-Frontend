package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.PokeathlonStatService;
import de.aix.pokebattler.model.pokemon.PokeathlonStatDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pokeathlon-stat")
public class PokeathlonStatController {
    private final PokeathlonStatService pokeathlonStatService;

    public PokeathlonStatController(PokeathlonStatService pokeathlonStatService) {
        this.pokeathlonStatService = pokeathlonStatService;
    }

    @GetMapping
    public ResponseEntity<List<PokeathlonStatDTO>> getAllPokeathlonStats() {
        return ResponseEntity.ok(pokeathlonStatService.getAllPokeathlonStats());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokeathlonStatDTO> getPokeathlonStatById(@PathVariable Long id) {
        return pokeathlonStatService.getPokeathlonStatById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PokeathlonStatDTO> getPokeathlonStatByName(@PathVariable String name) {
        return pokeathlonStatService.getPokeathlonStatByName(name)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
