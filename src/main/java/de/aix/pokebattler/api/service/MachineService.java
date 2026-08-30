package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.MachineRepository;
import de.aix.pokebattler.model.machine.Machine;
import de.aix.pokebattler.model.machine.MachineDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MachineService {
    private final MachineRepository machineRepository;

    @Transactional(readOnly = true)
    public List<MachineDTO> getAllMachines() {
        return machineRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<MachineDTO> getMachineById(Long id) {
        return machineRepository.findById(id)
            .map(this::toDTO);
    }

    @Transactional
    public MachineDTO createMachine(MachineDTO request) {
        Machine entity = Machine.builder()
            .id(request.getId())
            .build();

        Machine saved = machineRepository.save(entity);

        return toDTO(saved);
    }

    @Transactional
    public Optional<MachineDTO> updateMachine(Long id, MachineDTO request) {
        return machineRepository.findById(id).map(machine -> {
            Machine updated = machineRepository.save(machine);

            return toDTO(updated);
        });
    }

    @Transactional
    public boolean deleteMachine(Long id) {
        if (machineRepository.existsById(id)) {
            machineRepository.deleteById(id);

            return true;
        }

        return false;
    }

    private MachineDTO toDTO(Machine entity) {
        if (entity == null)
            return null;

        return MachineDTO.builder()
            .id(entity.getId())
            .itemId(entity.getItem() != null ? entity.getItem().getId() : null)
            .moveId(entity.getMove() != null ? entity.getMove().getId() : null)
            .versionGroupId(entity.getVersionGroup() != null ? entity.getVersionGroup().getId() : null)
            .build();
    }
}
