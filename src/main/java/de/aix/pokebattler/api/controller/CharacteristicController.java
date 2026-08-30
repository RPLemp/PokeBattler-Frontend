package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.CharacteristicService;
import de.aix.pokebattler.model.pokemon.CharacteristicDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/characteristic")
public class CharacteristicController {
    private final CharacteristicService characteristicService;

    public CharacteristicController(CharacteristicService characteristicService) {
        this.characteristicService = characteristicService;
    }

    @GetMapping
    public ResponseEntity<List<CharacteristicDTO>> getAllCharacteristics() {
        return ResponseEntity.ok(characteristicService.getAllCharacteristics());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacteristicDTO> getCharacteristicById(@PathVariable Long id) {
        return characteristicService.getCharacteristicById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
