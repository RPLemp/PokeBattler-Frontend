package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.PokemonService;
import de.aix.pokebattler.model.pokemon.PokemonDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pokemon")
@RequiredArgsConstructor
public class PokemonController {
    private final PokemonService pokemonService;

    @GetMapping
    public ResponseEntity<List<PokemonDTO>> getAllPokemon() {
        List<PokemonDTO> pokemon = pokemonService.getAllPokemons();

        if (pokemon.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(pokemon);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonDTO> getPokemonById(@PathVariable Long id) {
        return pokemonService.getPokemonById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PokemonDTO> createPokemon(@Valid @RequestBody PokemonDTO request) {
        PokemonDTO created = pokemonService.createPokemon(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PokemonDTO> updatePokemon(@PathVariable Long id, @Valid @RequestBody PokemonDTO request) {
        return pokemonService.updatePokemon(id, request)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePokemon(@PathVariable Long id) {
        return pokemonService.deletePokemon(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
