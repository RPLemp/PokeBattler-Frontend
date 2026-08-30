package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.SuperContestEffectRepository;
import de.aix.pokebattler.model.contest.SuperContestEffect;
import de.aix.pokebattler.model.contest.SuperContestEffectDTO;
import de.aix.pokebattler.model.move.Move;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SuperContestEffectService {
    private final SuperContestEffectRepository superContestEffectRepository;

    @Transactional(readOnly = true)
    public List<SuperContestEffectDTO> getAllSuperContestEffects() {
        return superContestEffectRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<SuperContestEffectDTO> getSuperContestEffectById(Long id) {
        return superContestEffectRepository.findById(id)
            .map(this::toDTO);
    }

    @Transactional
    public SuperContestEffectDTO createSuperContestEffect(SuperContestEffectDTO request) {
        SuperContestEffect entity = SuperContestEffect.builder()
            .id(request.getId())
            .appeal(request.getAppeal())
            .flavorText(request.getFlavorText())
            .build();

        SuperContestEffect saved = superContestEffectRepository.save(entity);

        return toDTO(saved);
    }

    @Transactional
    public Optional<SuperContestEffectDTO> updateSuperContestEffect(Long id, SuperContestEffectDTO request) {
        return superContestEffectRepository.findById(id).map(effect -> {
            effect.setAppeal(request.getAppeal());
            effect.setFlavorText(request.getFlavorText());

            SuperContestEffect updated = superContestEffectRepository.save(effect);

            return toDTO(updated);
        });
    }

    @Transactional
    public boolean deleteSuperContestEffect(Long id) {
        if (superContestEffectRepository.existsById(id)) {
            superContestEffectRepository.deleteById(id);

            return true;
        }

        return false;
    }

    private SuperContestEffectDTO toDTO(SuperContestEffect entity) {
        if (entity == null)
            return null;

        return SuperContestEffectDTO.builder()
            .id(entity.getId())
            .appeal(entity.getAppeal())
            .flavorText(entity.getFlavorText())
            .moveIds(entity.getMoves() != null ? entity.getMoves().stream().map(Move::getId).toList() : null)
            .build();
    }
}
