package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.ItemCategoryRepository;
import de.aix.pokebattler.model.item.Item;
import de.aix.pokebattler.model.item.ItemCategory;
import de.aix.pokebattler.model.item.ItemCategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemCategoryService {
    private final ItemCategoryRepository itemCategoryRepository;

    @Transactional(readOnly = true)
    public List<ItemCategoryDTO> getAllItemCategories() {
        return itemCategoryRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<ItemCategoryDTO> getItemCategoryById(Long id) {
        return itemCategoryRepository.findById(id)
            .map(this::toDTO);
    }

    @Transactional
    public ItemCategoryDTO createItemCategory(ItemCategoryDTO request) {
        ItemCategory entity = ItemCategory.builder()
            .id(request.getId())
            .name(request.getName())
            .build();

        ItemCategory saved = itemCategoryRepository.save(entity);

        return toDTO(saved);
    }

    @Transactional
    public Optional<ItemCategoryDTO> updateItemCategory(Long id, ItemCategoryDTO request) {
        return itemCategoryRepository.findById(id).map(cat -> {
            cat.setName(request.getName());
            ItemCategory updated = itemCategoryRepository.save(cat);

            return toDTO(updated);
        });
    }

    @Transactional
    public boolean deleteItemCategory(Long id) {
        if (itemCategoryRepository.existsById(id)) {
            itemCategoryRepository.deleteById(id);

            return true;
        }

        return false;
    }

    private ItemCategoryDTO toDTO(ItemCategory entity) {
        if (entity == null)
            return null;

        return ItemCategoryDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .pocketId(entity.getPocket() != null ? entity.getPocket().getId() : null)
            .itemIds(entity.getItems() != null ? entity.getItems().stream().map(Item::getId).toList() : null)
            .build();
    }
}
