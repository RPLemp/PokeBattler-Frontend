package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.PokemonColorService;
import de.aix.pokebattler.model.pokemon.PokemonColorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pokemon-color")
public class PokemonColorController {
    private final PokemonColorService pokemonColorService;

    public PokemonColorController(PokemonColorService pokemonColorService) {
        this.pokemonColorService = pokemonColorService;
    }

    @GetMapping
    public ResponseEntity<List<PokemonColorDTO>> getAllPokemonColors() {
        return ResponseEntity.ok(pokemonColorService.getAllPokemonColors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonColorDTO> getPokemonColorById(@PathVariable Long id) {
        return pokemonColorService.getPokemonColorById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PokemonColorDTO> getPokemonColorByName(@PathVariable String name) {
        return pokemonColorService.getPokemonColorByName(name)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
