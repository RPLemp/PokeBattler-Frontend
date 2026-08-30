package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.EvolutionTriggerRepository;
import de.aix.pokebattler.model.evolution.EvolutionTrigger;
import de.aix.pokebattler.model.evolution.EvolutionTriggerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EvolutionTriggerService {
    private final EvolutionTriggerRepository evolutionTriggerRepository;

    @Transactional(readOnly = true)
    public List<EvolutionTriggerDTO> getAllEvolutionTriggers() {
        return evolutionTriggerRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<EvolutionTriggerDTO> getEvolutionTriggerById(Long id) {
        return evolutionTriggerRepository.findById(id)
            .map(this::toDTO);
    }

    @Transactional
    public EvolutionTriggerDTO createEvolutionTrigger(EvolutionTriggerDTO request) {
        EvolutionTrigger entity = EvolutionTrigger.builder()
            .id(request.getId())
            .name(request.getName())
            .build();

        EvolutionTrigger saved = evolutionTriggerRepository.save(entity);

        return toDTO(saved);
    }

    @Transactional
    public Optional<EvolutionTriggerDTO> updateEvolutionTrigger(Long id, EvolutionTriggerDTO request) {
        return evolutionTriggerRepository.findById(id).map(trigger -> {
            trigger.setName(request.getName());
            EvolutionTrigger updated = evolutionTriggerRepository.save(trigger);

            return toDTO(updated);
        });
    }

    @Transactional
    public boolean deleteEvolutionTrigger(Long id) {
        if (evolutionTriggerRepository.existsById(id)) {
            evolutionTriggerRepository.deleteById(id);

            return true;
        }

        return false;
    }

    private EvolutionTriggerDTO toDTO(EvolutionTrigger entity) {
        if (entity == null)
            return null;

        return EvolutionTriggerDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .build();
    }
}
