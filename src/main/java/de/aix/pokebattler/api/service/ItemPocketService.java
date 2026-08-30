package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.ItemPocketRepository;
import de.aix.pokebattler.model.item.ItemCategory;
import de.aix.pokebattler.model.item.ItemPocket;
import de.aix.pokebattler.model.item.ItemPocketDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemPocketService {
    private final ItemPocketRepository itemPocketRepository;

    @Transactional(readOnly = true)
    public List<ItemPocketDTO> getAllItemPockets() {
        return itemPocketRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<ItemPocketDTO> getItemPocketById(Long id) {
        return itemPocketRepository.findById(id)
            .map(this::toDTO);
    }

    @Transactional
    public ItemPocketDTO createItemPocket(ItemPocketDTO request) {
        ItemPocket entity = ItemPocket.builder()
            .id(request.getId())
            .name(request.getName())
            .build();

        ItemPocket saved = itemPocketRepository.save(entity);

        return toDTO(saved);
    }

    @Transactional
    public Optional<ItemPocketDTO> updateItemPocket(Long id, ItemPocketDTO request) {
        return itemPocketRepository.findById(id).map(pocket -> {
            pocket.setName(request.getName());
            ItemPocket updated = itemPocketRepository.save(pocket);

            return toDTO(updated);
        });
    }

    @Transactional
    public boolean deleteItemPocket(Long id) {
        if (itemPocketRepository.existsById(id)) {
            itemPocketRepository.deleteById(id);

            return true;
        }

        return false;
    }

    private ItemPocketDTO toDTO(ItemPocket entity) {
        if (entity == null)
            return null;

        return ItemPocketDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .categoryIds(entity.getCategories() != null ? entity.getCategories().stream().map(ItemCategory::getId).toList() : null)
            .build();
    }
}
