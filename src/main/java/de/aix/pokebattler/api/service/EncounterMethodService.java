package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.EncounterMethodRepository;
import de.aix.pokebattler.model.encounter.EncounterMethod;
import de.aix.pokebattler.model.encounter.EncounterMethodDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EncounterMethodService {
    private final EncounterMethodRepository encounterMethodRepository;

    @Transactional(readOnly = true)
    public List<EncounterMethodDTO> getAllEncounterMethods() {
        return encounterMethodRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<EncounterMethodDTO> getEncounterMethodById(Long id) {
        return encounterMethodRepository.findById(id)
            .map(this::toDTO);
    }

    @Transactional
    public EncounterMethodDTO createEncounterMethod(EncounterMethodDTO request) {
        EncounterMethod entity = EncounterMethod.builder()
            .id(request.getId())
            .name(request.getName())
            .order(request.getOrder())
            .build();

        EncounterMethod saved = encounterMethodRepository.save(entity);

        return toDTO(saved);
    }

    @Transactional
    public Optional<EncounterMethodDTO> updateEncounterMethod(Long id, EncounterMethodDTO request) {
        return encounterMethodRepository.findById(id).map(method -> {
            method.setName(request.getName());
            method.setOrder(request.getOrder());

            EncounterMethod updated = encounterMethodRepository.save(method);

            return toDTO(updated);
        });
    }

    @Transactional
    public boolean deleteEncounterMethod(Long id) {
        if (encounterMethodRepository.existsById(id)) {
            encounterMethodRepository.deleteById(id);

            return true;
        }

        return false;
    }

    private EncounterMethodDTO toDTO(EncounterMethod entity) {
        if (entity == null)
            return null;

        return EncounterMethodDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .order(entity.getOrder())
            .build();
    }
}
