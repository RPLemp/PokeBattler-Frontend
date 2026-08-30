package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.GrowthRateService;
import de.aix.pokebattler.model.pokemon.GrowthRateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/growth-rate")
public class GrowthRateController {
    private final GrowthRateService growthRateService;

    public GrowthRateController(GrowthRateService growthRateService) {
        this.growthRateService = growthRateService;
    }

    @GetMapping
    public ResponseEntity<List<GrowthRateDTO>> getAllGrowthRates() {
        return ResponseEntity.ok(growthRateService.getAllGrowthRates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrowthRateDTO> getGrowthRateById(@PathVariable Long id) {
        return growthRateService.getGrowthRateById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<GrowthRateDTO> getGrowthRateByName(@PathVariable String name) {
        return growthRateService.getGrowthRateByName(name)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
