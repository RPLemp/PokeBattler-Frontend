package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.PokemonShapeService;
import de.aix.pokebattler.model.pokemon.PokemonShapeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pokemon-shape")
public class PokemonShapeController {
    private final PokemonShapeService pokemonShapeService;

    public PokemonShapeController(PokemonShapeService pokemonShapeService) {
        this.pokemonShapeService = pokemonShapeService;
    }

    @GetMapping
    public ResponseEntity<List<PokemonShapeDTO>> getAllPokemonShapes() {
        return ResponseEntity.ok(pokemonShapeService.getAllPokemonShapes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonShapeDTO> getPokemonShapeById(@PathVariable Long id) {
        return pokemonShapeService.getPokemonShapeById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PokemonShapeDTO> getPokemonShapeByName(@PathVariable String name) {
        return pokemonShapeService.getPokemonShapeByName(name)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
