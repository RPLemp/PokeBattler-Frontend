package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.PokedexService;
import de.aix.pokebattler.model.game.PokedexDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pokedex")
@RequiredArgsConstructor
public class PokedexController {
    private final PokedexService pokedexService;

    @GetMapping
    public ResponseEntity<List<PokedexDTO>> getAllPokedexes() {
        List<PokedexDTO> items = pokedexService.getAllPokedexes();

        if (items.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokedexDTO> getPokedexById(@PathVariable Long id) {
        return pokedexService.getPokedexById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PokedexDTO> createPokedex(@Valid @RequestBody PokedexDTO request) {
        PokedexDTO created = pokedexService.createPokedex(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PokedexDTO> updatePokedex(@PathVariable Long id, @Valid @RequestBody PokedexDTO request) {
        return pokedexService.updatePokedex(id, request)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePokedex(@PathVariable Long id) {
        return pokedexService.deletePokedex(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
