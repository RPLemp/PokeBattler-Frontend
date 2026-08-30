package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.BerryFirmnessRepository;
import de.aix.pokebattler.model.berry.Berry;
import de.aix.pokebattler.model.berry.BerryFirmness;
import de.aix.pokebattler.model.berry.BerryFirmnessDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BerryFirmnessService {
    private final BerryFirmnessRepository berryFirmnessRepository;

    @Transactional(readOnly = true)
    public List<BerryFirmnessDTO> getAllBerryFirmnesses() {
        return berryFirmnessRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<BerryFirmnessDTO> getBerryFirmnessById(Long id) {
        return berryFirmnessRepository.findById(id)
            .map(this::toDTO);
    }

    @Transactional
    public BerryFirmnessDTO createBerryFirmness(BerryFirmnessDTO request) {
        BerryFirmness entity = BerryFirmness.builder()
            .id(request.getId())
            .name(request.getName())
            .build();

        BerryFirmness saved = berryFirmnessRepository.save(entity);

        return toDTO(saved);
    }

    @Transactional
    public Optional<BerryFirmnessDTO> updateBerryFirmness(Long id, BerryFirmnessDTO request) {
        return berryFirmnessRepository.findById(id).map(firmness -> {
            firmness.setName(request.getName());
            BerryFirmness updated = berryFirmnessRepository.save(firmness);

            return toDTO(updated);
        });
    }

    @Transactional
    public boolean deleteBerryFirmness(Long id) {
        if (berryFirmnessRepository.existsById(id)) {
            berryFirmnessRepository.deleteById(id);

            return true;
        }

        return false;
    }

    private BerryFirmnessDTO toDTO(BerryFirmness entity) {
        if (entity == null)
            return null;

        return BerryFirmnessDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .berryIds(entity.getBerries() != null ? entity.getBerries().stream().map(Berry::getId).toList() : null)
            .build();
    }
}
