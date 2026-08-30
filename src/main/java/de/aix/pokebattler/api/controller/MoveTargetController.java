package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.MoveTargetService;
import de.aix.pokebattler.model.move.MoveTargetDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/move-target")
public class MoveTargetController {
    private final MoveTargetService moveTargetService;

    public MoveTargetController(MoveTargetService moveTargetService) {
        this.moveTargetService = moveTargetService;
    }

    @GetMapping
    public ResponseEntity<List<MoveTargetDTO>> getAllMoveTargets() {
        return ResponseEntity.ok(moveTargetService.getAllMoveTargets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MoveTargetDTO> getMoveTargetById(@PathVariable Long id) {
        return moveTargetService.getMoveTargetById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<MoveTargetDTO> getMoveTargetByName(@PathVariable String name) {
        return moveTargetService.getMoveTargetByName(name)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
