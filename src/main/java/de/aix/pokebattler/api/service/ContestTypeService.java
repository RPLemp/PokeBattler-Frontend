package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.ContestTypeRepository;
import de.aix.pokebattler.model.contest.ContestType;
import de.aix.pokebattler.model.contest.ContestTypeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContestTypeService {
    private final ContestTypeRepository contestTypeRepository;

    @Transactional(readOnly = true)
    public List<ContestTypeDTO> getAllContestTypes() {
        return contestTypeRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<ContestTypeDTO> getContestTypeById(Long id) {
        return contestTypeRepository.findById(id)
            .map(this::toDTO);
    }

    @Transactional
    public ContestTypeDTO createContestType(ContestTypeDTO request) {
        ContestType entity = ContestType.builder()
            .id(request.getId())
            .name(request.getName())
            .build();

        ContestType saved = contestTypeRepository.save(entity);

        return toDTO(saved);
    }

    @Transactional
    public Optional<ContestTypeDTO> updateContestType(Long id, ContestTypeDTO request) {
        return contestTypeRepository.findById(id).map(type -> {
            type.setName(request.getName());
            ContestType updated = contestTypeRepository.save(type);

            return toDTO(updated);
        });
    }

    @Transactional
    public boolean deleteContestType(Long id) {
        if (contestTypeRepository.existsById(id)) {
            contestTypeRepository.deleteById(id);

            return true;
        }

        return false;
    }

    private ContestTypeDTO toDTO(ContestType entity) {
        if (entity == null)
            return null;

        return ContestTypeDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .berryFlavorId(entity.getBerryFlavor() != null ? entity.getBerryFlavor().getId() : null)
            .build();
    }
}
