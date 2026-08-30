package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.ItemRepository;
import de.aix.pokebattler.model.item.Item;
import de.aix.pokebattler.model.item.ItemAttribute;
import de.aix.pokebattler.model.item.ItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional(readOnly = true)
    public List<ItemDTO> getAllItems() {
        return itemRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<ItemDTO> getItemById(Long id) {
        return itemRepository.findById(id)
            .map(this::toDTO);
    }

    @Transactional
    public ItemDTO createItem(ItemDTO request) {
        Item entity = Item.builder()
            .id(request.getId())
            .name(request.getName())
            .cost(request.getCost())
            .flingPower(request.getFlingPower())
            .build();

        Item saved = itemRepository.save(entity);

        return toDTO(saved);
    }

    @Transactional
    public Optional<ItemDTO> updateItem(Long id, ItemDTO request) {
        return itemRepository.findById(id).map(item -> {
            item.setName(request.getName());
            item.setCost(request.getCost());
            item.setFlingPower(request.getFlingPower());
            Item updated = itemRepository.save(item);

            return toDTO(updated);
        });
    }

    @Transactional
    public boolean deleteItem(Long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);

            return true;
        }

        return false;
    }

    private ItemDTO toDTO(Item entity) {
        if (entity == null)
            return null;

        return ItemDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .cost(entity.getCost())
            .flingPower(entity.getFlingPower())
            .flingEffectId(entity.getFlingEffect() != null ? entity.getFlingEffect().getId() : null)
            .categoryId(entity.getCategory() != null ? entity.getCategory().getId() : null)
            .babyTriggerForId(entity.getBabyTriggerFor() != null ? entity.getBabyTriggerFor().getId() : null)
            .attributeIds(entity.getAttributes() != null ? entity.getAttributes().stream().map(ItemAttribute::getId).toList() : null)
            .build();
    }
}
