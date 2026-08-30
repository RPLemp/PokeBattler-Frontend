package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.NatureRepository;
import de.aix.pokebattler.model.pokemon.Nature;
import de.aix.pokebattler.model.pokemon.NatureDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NatureService {
    private final NatureRepository natureRepository;

    public NatureService(NatureRepository natureRepository) {
        this.natureRepository = natureRepository;
    }

    public List<NatureDTO> getAllNatures() {
        return natureRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    public Optional<NatureDTO> getNatureById(Long id) {
        return natureRepository.findById(id)
            .map(this::toDTO);
    }

    public Optional<NatureDTO> getNatureByName(String name) {
        return natureRepository.findByNameIgnoreCase(name)
            .map(this::toDTO);
    }

    private NatureDTO toDTO(Nature entity) {
        if (entity == null)
            return null;

        return NatureDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .decreasedStatId(entity.getDecreasedStat() != null ? entity.getDecreasedStat().getId() : null)
            .increasedStatId(entity.getIncreasedStat() != null ? entity.getIncreasedStat().getId() : null)
            .hatesFlavorId(entity.getHatesFlavor() != null ? entity.getHatesFlavor().getId() : null)
            .likesFlavorId(entity.getLikesFlavor() != null ? entity.getLikesFlavor().getId() : null)
            .pokeathlonStatId(entity.getPokeathlonStat() != null ? entity.getPokeathlonStat().getId() : null)
            .build();
    }
}
