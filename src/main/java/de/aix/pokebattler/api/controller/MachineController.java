package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.MachineService;
import de.aix.pokebattler.model.machine.MachineDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/machine")
@RequiredArgsConstructor
public class MachineController {
    private final MachineService machineService;

    @GetMapping
    public ResponseEntity<List<MachineDTO>> getAllMachines() {
        List<MachineDTO> items = machineService.getAllMachines();

        if (items.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MachineDTO> getMachineById(@PathVariable Long id) {
        return machineService.getMachineById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MachineDTO> createMachine(@Valid @RequestBody MachineDTO request) {
        MachineDTO created = machineService.createMachine(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MachineDTO> updateMachine(@PathVariable Long id, @Valid @RequestBody MachineDTO request) {
        return machineService.updateMachine(id, request)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMachine(@PathVariable Long id) {
        return machineService.deleteMachine(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
