package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.TypeService;
import de.aix.pokebattler.model.pokemon.TypeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/type")
public class TypeController {
    private final TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping
    public ResponseEntity<List<TypeDTO>> getAllTypes() {
        return ResponseEntity.ok(typeService.getAllTypes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeDTO> getTypeById(@PathVariable Long id) {
        return typeService.getTypeById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<TypeDTO> getTypeByName(@PathVariable String name) {
        return typeService.getTypeByName(name)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
