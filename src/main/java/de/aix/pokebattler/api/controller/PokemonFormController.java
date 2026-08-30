package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.PokemonFormService;
import de.aix.pokebattler.model.pokemon.PokemonFormDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pokemon-form")
public class PokemonFormController {
    private final PokemonFormService pokemonFormService;

    public PokemonFormController(PokemonFormService pokemonFormService) {
        this.pokemonFormService = pokemonFormService;
    }

    @GetMapping
    public ResponseEntity<List<PokemonFormDTO>> getAllPokemonForms() {
        return ResponseEntity.ok(pokemonFormService.getAllPokemonForms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonFormDTO> getPokemonFormById(@PathVariable Long id) {
        return pokemonFormService.getPokemonFormById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PokemonFormDTO> getPokemonFormByName(@PathVariable String name) {
        return pokemonFormService.getPokemonFormByName(name)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
