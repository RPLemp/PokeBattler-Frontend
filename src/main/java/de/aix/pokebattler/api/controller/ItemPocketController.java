package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.ItemPocketService;
import de.aix.pokebattler.model.item.ItemPocketDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/item-pocket")
@RequiredArgsConstructor
public class ItemPocketController {
    private final ItemPocketService itemPocketService;

    @GetMapping
    public ResponseEntity<List<ItemPocketDTO>> getAllItemPockets() {
        List<ItemPocketDTO> items = itemPocketService.getAllItemPockets();

        if (items.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPocketDTO> getItemPocketById(@PathVariable Long id) {
        return itemPocketService.getItemPocketById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ItemPocketDTO> createItemPocket(@Valid @RequestBody ItemPocketDTO request) {
        ItemPocketDTO created = itemPocketService.createItemPocket(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemPocketDTO> updateItemPocket(@PathVariable Long id, @Valid @RequestBody ItemPocketDTO request) {
        return itemPocketService.updateItemPocket(id, request)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemPocket(@PathVariable Long id) {
        return itemPocketService.deleteItemPocket(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
