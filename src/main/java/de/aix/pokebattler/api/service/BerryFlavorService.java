package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.BerryFlavorRepository;
import de.aix.pokebattler.model.berry.Berry;
import de.aix.pokebattler.model.berry.BerryFlavor;
import de.aix.pokebattler.model.berry.BerryFlavorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BerryFlavorService {
    private final BerryFlavorRepository berryFlavorRepository;

    @Transactional(readOnly = true)
    public List<BerryFlavorDTO> getAllBerryFlavors() {
        return berryFlavorRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<BerryFlavorDTO> getBerryFlavorById(Long id) {
        return berryFlavorRepository.findById(id)
            .map(this::toDTO);
    }

    @Transactional
    public BerryFlavorDTO createBerryFlavor(BerryFlavorDTO request) {
        BerryFlavor entity = BerryFlavor.builder()
            .id(request.getId())
            .name(request.getName())
            .build();

        BerryFlavor saved = berryFlavorRepository.save(entity);

        return toDTO(saved);
    }

    @Transactional
    public Optional<BerryFlavorDTO> updateBerryFlavor(Long id, BerryFlavorDTO request) {
        return berryFlavorRepository.findById(id).map(flavor -> {
            flavor.setName(request.getName());
            BerryFlavor updated = berryFlavorRepository.save(flavor);

            return toDTO(updated);
        });
    }

    @Transactional
    public boolean deleteBerryFlavor(Long id) {
        if (berryFlavorRepository.existsById(id)) {
            berryFlavorRepository.deleteById(id);

            return true;
        }

        return false;
    }

    private BerryFlavorDTO toDTO(BerryFlavor entity) {
        if (entity == null)
            return null;

        return BerryFlavorDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .contestTypeId(entity.getContestType() != null ? entity.getContestType().getId() : null)
            .berryIds(entity.getBerries() != null ? entity.getBerries().stream().map(Berry::getId).toList() : null)
            .build();
    }
}
