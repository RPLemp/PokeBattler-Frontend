package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.ItemFlingEffectService;
import de.aix.pokebattler.model.item.ItemFlingEffectDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/item-fling-effect")
@RequiredArgsConstructor
public class ItemFlingEffectController {
    private final ItemFlingEffectService itemFlingEffectService;

    @GetMapping
    public ResponseEntity<List<ItemFlingEffectDTO>> getAllItemFlingEffects() {
        List<ItemFlingEffectDTO> items = itemFlingEffectService.getAllItemFlingEffects();

        if (items.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemFlingEffectDTO> getItemFlingEffectById(@PathVariable Long id) {
        return itemFlingEffectService.getItemFlingEffectById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ItemFlingEffectDTO> createItemFlingEffect(@Valid @RequestBody ItemFlingEffectDTO request) {
        ItemFlingEffectDTO created = itemFlingEffectService.createItemFlingEffect(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemFlingEffectDTO> updateItemFlingEffect(@PathVariable Long id, @Valid @RequestBody ItemFlingEffectDTO request) {
        return itemFlingEffectService.updateItemFlingEffect(id, request)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemFlingEffect(@PathVariable Long id) {
        return itemFlingEffectService.deleteItemFlingEffect(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
