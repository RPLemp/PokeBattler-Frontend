package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.CharacteristicRepository;
import de.aix.pokebattler.model.pokemon.Characteristic;
import de.aix.pokebattler.model.pokemon.CharacteristicDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacteristicService {
    private final CharacteristicRepository characteristicRepository;

    public CharacteristicService(CharacteristicRepository characteristicRepository) {
        this.characteristicRepository = characteristicRepository;
    }

    public List<CharacteristicDTO> getAllCharacteristics() {
        return characteristicRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    public Optional<CharacteristicDTO> getCharacteristicById(Long id) {
        return characteristicRepository.findById(id)
            .map(this::toDTO);
    }

    private CharacteristicDTO toDTO(Characteristic entity) {
        if (entity == null)
            return null;

        return CharacteristicDTO.builder()
            .id(entity.getId())
            .geneModulo(entity.getGeneModulo())
            .highestStatId(entity.getHighestStat() != null ? entity.getHighestStat().getId() : null)
            .build();
    }
}
