package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.ItemAttributeService;
import de.aix.pokebattler.model.item.ItemAttributeDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/item-attribute")
@RequiredArgsConstructor
public class ItemAttributeController {
    private final ItemAttributeService itemAttributeService;

    @GetMapping
    public ResponseEntity<List<ItemAttributeDTO>> getAllItemAttributes() {
        List<ItemAttributeDTO> items = itemAttributeService.getAllItemAttributes();

        if (items.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemAttributeDTO> getItemAttributeById(@PathVariable Long id) {
        return itemAttributeService.getItemAttributeById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ItemAttributeDTO> createItemAttribute(@Valid @RequestBody ItemAttributeDTO request) {
        ItemAttributeDTO created = itemAttributeService.createItemAttribute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemAttributeDTO> updateItemAttribute(@PathVariable Long id, @Valid @RequestBody ItemAttributeDTO request) {
        return itemAttributeService.updateItemAttribute(id, request)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemAttribute(@PathVariable Long id) {
        return itemAttributeService.deleteItemAttribute(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
