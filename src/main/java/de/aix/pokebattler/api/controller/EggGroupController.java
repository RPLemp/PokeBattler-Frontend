package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.EggGroupService;
import de.aix.pokebattler.model.pokemon.EggGroupDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/egg-group")
public class EggGroupController {
    private final EggGroupService eggGroupService;

    public EggGroupController(EggGroupService eggGroupService) {
        this.eggGroupService = eggGroupService;
    }

    @GetMapping
    public ResponseEntity<List<EggGroupDTO>> getAllEggGroups() {
        return ResponseEntity.ok(eggGroupService.getAllEggGroups());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EggGroupDTO> getEggGroupById(@PathVariable Long id) {
        return eggGroupService.getEggGroupById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<EggGroupDTO> getEggGroupByName(@PathVariable String name) {
        return eggGroupService.getEggGroupByName(name)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
