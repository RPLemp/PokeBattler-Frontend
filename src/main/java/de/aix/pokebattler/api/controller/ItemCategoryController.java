package de.aix.pokebattler.api.controller;

import de.aix.pokebattler.api.service.ItemCategoryService;
import de.aix.pokebattler.model.item.ItemCategoryDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/item-category")
@RequiredArgsConstructor
public class ItemCategoryController {
    private final ItemCategoryService itemCategoryService;

    @GetMapping
    public ResponseEntity<List<ItemCategoryDTO>> getAllItemCategories() {
        List<ItemCategoryDTO> items = itemCategoryService.getAllItemCategories();

        if (items.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemCategoryDTO> getItemCategoryById(@PathVariable Long id) {
        return itemCategoryService.getItemCategoryById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ItemCategoryDTO> createItemCategory(@Valid @RequestBody ItemCategoryDTO request) {
        ItemCategoryDTO created = itemCategoryService.createItemCategory(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemCategoryDTO> updateItemCategory(@PathVariable Long id, @Valid @RequestBody ItemCategoryDTO request) {
        return itemCategoryService.updateItemCategory(id, request)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemCategory(@PathVariable Long id) {
        return itemCategoryService.deleteItemCategory(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
