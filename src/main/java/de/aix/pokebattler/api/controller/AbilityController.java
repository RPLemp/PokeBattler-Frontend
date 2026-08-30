package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.AbilityService;
import de.aix.pokebattler.model.pokemon.AbilityDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ability")
public class AbilityController {
    private final AbilityService abilityService;

    public AbilityController(AbilityService abilityService) {
        this.abilityService = abilityService;
    }

    @GetMapping
    public ResponseEntity<List<AbilityDTO>> getAllAbilities() {
        return ResponseEntity.ok(abilityService.getAllAbilities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbilityDTO> getAbilityById(@PathVariable Long id) {
        return abilityService.getAbilityById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<AbilityDTO> getAbilityByName(@PathVariable String name) {
        return abilityService.getAbilityByName(name)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
