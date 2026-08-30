package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.ItemAttributeRepository;
import de.aix.pokebattler.model.item.Item;
import de.aix.pokebattler.model.item.ItemAttribute;
import de.aix.pokebattler.model.item.ItemAttributeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemAttributeService {
    private final ItemAttributeRepository itemAttributeRepository;

    @Transactional(readOnly = true)
    public List<ItemAttributeDTO> getAllItemAttributes() {
        return itemAttributeRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<ItemAttributeDTO> getItemAttributeById(Long id) {
        return itemAttributeRepository.findById(id)
            .map(this::toDTO);
    }

    @Transactional
    public ItemAttributeDTO createItemAttribute(ItemAttributeDTO request) {
        ItemAttribute entity = ItemAttribute.builder()
            .id(request.getId())
            .name(request.getName())
            .build();

        ItemAttribute saved = itemAttributeRepository.save(entity);

        return toDTO(saved);
    }

    @Transactional
    public Optional<ItemAttributeDTO> updateItemAttribute(Long id, ItemAttributeDTO request) {
        return itemAttributeRepository.findById(id).map(attr -> {
            attr.setName(request.getName());
            ItemAttribute updated = itemAttributeRepository.save(attr);

            return toDTO(updated);
        });
    }

    @Transactional
    public boolean deleteItemAttribute(Long id) {
        if (itemAttributeRepository.existsById(id)) {
            itemAttributeRepository.deleteById(id);

            return true;
        }

        return false;
    }

    private ItemAttributeDTO toDTO(ItemAttribute entity) {
        if (entity == null)
            return null;

        return ItemAttributeDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .itemIds(entity.getItems() != null ? entity.getItems().stream().map(Item::getId).toList() : null)
            .build();
    }
}
