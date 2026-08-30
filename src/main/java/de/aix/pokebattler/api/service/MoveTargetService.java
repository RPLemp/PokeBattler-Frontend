package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.MoveTargetRepository;
import de.aix.pokebattler.model.move.Move;
import de.aix.pokebattler.model.move.MoveTarget;
import de.aix.pokebattler.model.move.MoveTargetDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoveTargetService {
    private final MoveTargetRepository moveTargetRepository;

    public MoveTargetService(MoveTargetRepository moveTargetRepository) {
        this.moveTargetRepository = moveTargetRepository;
    }

    public List<MoveTargetDTO> getAllMoveTargets() {
        return moveTargetRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    public Optional<MoveTargetDTO> getMoveTargetById(Long id) {
        return moveTargetRepository.findById(id)
            .map(this::toDTO);
    }

    public Optional<MoveTargetDTO> getMoveTargetByName(String name) {
        return moveTargetRepository.findByNameIgnoreCase(name)
            .map(this::toDTO);
    }

    private MoveTargetDTO toDTO(MoveTarget entity) {
        if (entity == null)
            return null;

        return MoveTargetDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .moveIds(entity.getMoves() != null
                    ? entity.getMoves().stream().map(Move::getId).toList()
                    : null)
            .build();
    }
}
