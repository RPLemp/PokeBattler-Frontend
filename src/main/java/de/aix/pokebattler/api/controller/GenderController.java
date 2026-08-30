package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.GenderService;
import de.aix.pokebattler.model.pokemon.GenderDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/gender")
public class GenderController {
    private final GenderService genderService;

    public GenderController(GenderService genderService) {
        this.genderService = genderService;
    }

    @GetMapping
    public ResponseEntity<List<GenderDTO>> getAllGenders() {
        return ResponseEntity.ok(genderService.getAllGenders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenderDTO> getGenderById(@PathVariable Long id) {
        return genderService.getGenderById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<GenderDTO> getGenderByName(@PathVariable String name) {
        return genderService.getGenderByName(name)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
