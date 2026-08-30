package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.EncounterConditionRepository;
import de.aix.pokebattler.model.encounter.EncounterCondition;
import de.aix.pokebattler.model.encounter.EncounterConditionDTO;
import de.aix.pokebattler.model.encounter.EncounterConditionValue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EncounterConditionService {
    private final EncounterConditionRepository encounterConditionRepository;

    @Transactional(readOnly = true)
    public List<EncounterConditionDTO> getAllEncounterConditions() {
        return encounterConditionRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<EncounterConditionDTO> getEncounterConditionById(Long id) {
        return encounterConditionRepository.findById(id)
            .map(this::toDTO);
    }

    @Transactional
    public EncounterConditionDTO createEncounterCondition(EncounterConditionDTO request) {
        EncounterCondition entity = EncounterCondition.builder()
            .id(request.getId())
            .name(request.getName())
            .build();

        EncounterCondition saved = encounterConditionRepository.save(entity);

        return toDTO(saved);
    }

    @Transactional
    public Optional<EncounterConditionDTO> updateEncounterCondition(Long id, EncounterConditionDTO request) {
        return encounterConditionRepository.findById(id).map(condition -> {
            condition.setName(request.getName());
            EncounterCondition updated = encounterConditionRepository.save(condition);

            return toDTO(updated);
        });
    }

    @Transactional
    public boolean deleteEncounterCondition(Long id) {
        if (encounterConditionRepository.existsById(id)) {
            encounterConditionRepository.deleteById(id);

            return true;
        }

        return false;
    }

    private EncounterConditionDTO toDTO(EncounterCondition entity) {
        if (entity == null)
            return null;

        return EncounterConditionDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .valueIds(entity.getValues() != null ? entity.getValues().stream().map(EncounterConditionValue::getId).toList() : null)
            .build();
    }
}
