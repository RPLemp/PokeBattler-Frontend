package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.EncounterConditionValueRepository;
import de.aix.pokebattler.model.encounter.EncounterConditionValue;
import de.aix.pokebattler.model.encounter.EncounterConditionValueDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EncounterConditionValueService {
    private final EncounterConditionValueRepository encounterConditionValueRepository;

    @Transactional(readOnly = true)
    public List<EncounterConditionValueDTO> getAllEncounterConditionValues() {
        return encounterConditionValueRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<EncounterConditionValueDTO> getEncounterConditionValueById(Long id) {
        return encounterConditionValueRepository.findById(id)
            .map(this::toDTO);
    }

    @Transactional
    public EncounterConditionValueDTO createEncounterConditionValue(EncounterConditionValueDTO request) {
        EncounterConditionValue entity = EncounterConditionValue.builder()
            .id(request.getId())
            .name(request.getName())
            .build();

        EncounterConditionValue saved = encounterConditionValueRepository.save(entity);

        return toDTO(saved);
    }

    @Transactional
    public Optional<EncounterConditionValueDTO> updateEncounterConditionValue(Long id, EncounterConditionValueDTO request) {
        return encounterConditionValueRepository.findById(id).map(value -> {
            value.setName(request.getName());
            EncounterConditionValue updated = encounterConditionValueRepository.save(value);

            return toDTO(updated);
        });
    }

    @Transactional
    public boolean deleteEncounterConditionValue(Long id) {
        if (encounterConditionValueRepository.existsById(id)) {
            encounterConditionValueRepository.deleteById(id);

            return true;
        }

        return false;
    }

    private EncounterConditionValueDTO toDTO(EncounterConditionValue entity) {
        if (entity == null)
            return null;

        return EncounterConditionValueDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .conditionId(entity.getCondition() != null ? entity.getCondition().getId() : null)
            .build();
    }
}
