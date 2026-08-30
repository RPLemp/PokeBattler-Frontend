package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.ItemFlingEffectRepository;
import de.aix.pokebattler.model.item.Item;
import de.aix.pokebattler.model.item.ItemFlingEffect;
import de.aix.pokebattler.model.item.ItemFlingEffectDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemFlingEffectService {
    private final ItemFlingEffectRepository itemFlingEffectRepository;

    @Transactional(readOnly = true)
    public List<ItemFlingEffectDTO> getAllItemFlingEffects() {
        return itemFlingEffectRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<ItemFlingEffectDTO> getItemFlingEffectById(Long id) {
        return itemFlingEffectRepository.findById(id)
            .map(this::toDTO);
    }

    @Transactional
    public ItemFlingEffectDTO createItemFlingEffect(ItemFlingEffectDTO request) {
        ItemFlingEffect entity = ItemFlingEffect.builder()
            .id(request.getId())
            .name(request.getName())
            .build();

        ItemFlingEffect saved = itemFlingEffectRepository.save(entity);

        return toDTO(saved);
    }

    @Transactional
    public Optional<ItemFlingEffectDTO> updateItemFlingEffect(Long id, ItemFlingEffectDTO request) {
        return itemFlingEffectRepository.findById(id).map(effect -> {
            effect.setName(request.getName());
            ItemFlingEffect updated = itemFlingEffectRepository.save(effect);

            return toDTO(updated);
        });
    }

    @Transactional
    public boolean deleteItemFlingEffect(Long id) {
        if (itemFlingEffectRepository.existsById(id)) {
            itemFlingEffectRepository.deleteById(id);

            return true;
        }

        return false;
    }

    private ItemFlingEffectDTO toDTO(ItemFlingEffect entity) {
        if (entity == null)
            return null;

        return ItemFlingEffectDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .itemIds(entity.getItems() != null ? entity.getItems().stream().map(Item::getId).toList() : null)
            .build();
    }
}
