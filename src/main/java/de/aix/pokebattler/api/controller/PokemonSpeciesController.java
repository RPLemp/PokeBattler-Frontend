package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.PokemonSpeciesService;
import de.aix.pokebattler.model.pokemon.PokemonSpeciesDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pokemon-species")
public class PokemonSpeciesController {

    private final PokemonSpeciesService pokemonSpeciesService;

    public PokemonSpeciesController(PokemonSpeciesService pokemonSpeciesService) {
        this.pokemonSpeciesService = pokemonSpeciesService;
    }

    @GetMapping
    public ResponseEntity<List<PokemonSpeciesDTO>> getAllPokemonSpecies() {
        return ResponseEntity.ok(pokemonSpeciesService.getAllPokemonSpecies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonSpeciesDTO> getPokemonSpeciesById(@PathVariable Long id) {
        return pokemonSpeciesService.getPokemonSpeciesById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PokemonSpeciesDTO> getPokemonSpeciesByName(@PathVariable String name) {
        return pokemonSpeciesService.getPokemonSpeciesByName(name)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
