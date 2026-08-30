package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.BerryRepository;
import de.aix.pokebattler.model.berry.Berry;
import de.aix.pokebattler.model.berry.BerryDTO;
import de.aix.pokebattler.model.berry.BerryFlavor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BerryService {
    private final BerryRepository berryRepository;

    @Transactional(readOnly = true)
    public List<BerryDTO> getAllBerries() {
        return berryRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<BerryDTO> getBerryById(Long id) {
        return berryRepository.findById(id)
            .map(this::toDTO);
    }

    @Transactional
    public BerryDTO createBerry(BerryDTO request) {
        Berry entity = Berry.builder()
            .id(request.getId())
            .name(request.getName())
            .growthTime(request.getGrowthTime())
            .maxHarvest(request.getMaxHarvest())
            .naturalGiftPower(request.getNaturalGiftPower())
            .size(request.getSize())
            .smoothness(request.getSmoothness())
            .soilDryness(request.getSoilDryness())
            .build();
        Berry saved = berryRepository.save(entity);

        return toDTO(saved);
    }

    @Transactional
    public Optional<BerryDTO> updateBerry(Long id, BerryDTO request) {
        return berryRepository.findById(id).map(berry -> {
            berry.setName(request.getName());
            berry.setGrowthTime(request.getGrowthTime());
            berry.setMaxHarvest(request.getMaxHarvest());
            berry.setNaturalGiftPower(request.getNaturalGiftPower());
            berry.setSize(request.getSize());
            berry.setSmoothness(request.getSmoothness());
            berry.setSoilDryness(request.getSoilDryness());

            Berry updated = berryRepository.save(berry);

            return toDTO(updated);
        });
    }

    @Transactional
    public boolean deleteBerry(Long id) {
        if (berryRepository.existsById(id)) {
            berryRepository.deleteById(id);

            return true;
        }

        return false;
    }

    private BerryDTO toDTO(Berry entity) {
        if (entity == null)
            return null;

        return BerryDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .growthTime(entity.getGrowthTime())
            .maxHarvest(entity.getMaxHarvest())
            .naturalGiftPower(entity.getNaturalGiftPower())
            .size(entity.getSize())
            .smoothness(entity.getSmoothness())
            .soilDryness(entity.getSoilDryness())
            .firmnessId(entity.getFirmness() != null ? entity.getFirmness().getId() : null)
            .itemId(entity.getItem() != null ? entity.getItem().getId() : null)
            .naturalGiftTypeId(entity.getNaturalGiftType() != null ? entity.getNaturalGiftType().getId() : null)
            .flavorIds(entity.getFlavors() != null ? entity.getFlavors().stream().map(BerryFlavor::getId).toList() : null)
            .build();
    }
}
