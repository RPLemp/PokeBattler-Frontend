package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.PokemonHabitatService;
import de.aix.pokebattler.model.pokemon.PokemonHabitatDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pokemon-habitat")
public class PokemonHabitatController {
    private final PokemonHabitatService pokemonHabitatService;

    public PokemonHabitatController(PokemonHabitatService pokemonHabitatService) {
        this.pokemonHabitatService = pokemonHabitatService;
    }

    @GetMapping
    public ResponseEntity<List<PokemonHabitatDTO>> getAllPokemonHabitats() {
        return ResponseEntity.ok(pokemonHabitatService.getAllPokemonHabitats());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonHabitatDTO> getPokemonHabitatById(@PathVariable Long id) {
        return pokemonHabitatService.getPokemonHabitatById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PokemonHabitatDTO> getPokemonHabitatByName(@PathVariable String name) {
        return pokemonHabitatService.getPokemonHabitatByName(name)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
