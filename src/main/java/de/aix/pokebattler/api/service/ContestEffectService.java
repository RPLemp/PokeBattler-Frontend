package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.ContestEffectRepository;
import de.aix.pokebattler.model.contest.ContestEffect;
import de.aix.pokebattler.model.contest.ContestEffectDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContestEffectService {
    private final ContestEffectRepository contestEffectRepository;

    @Transactional(readOnly = true)
    public List<ContestEffectDTO> getAllContestEffects() {
        return contestEffectRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<ContestEffectDTO> getContestEffectById(Long id) {
        return contestEffectRepository.findById(id)
            .map(this::toDTO);
    }

    @Transactional
    public ContestEffectDTO createContestEffect(ContestEffectDTO request) {
        ContestEffect entity = ContestEffect.builder()
            .id(request.getId())
            .appeal(request.getAppeal())
            .jam(request.getJam())
            .effect(request.getEffect())
            .flavorText(request.getFlavorText())
            .build();

        ContestEffect saved = contestEffectRepository.save(entity);

        return toDTO(saved);
    }

    @Transactional
    public Optional<ContestEffectDTO> updateContestEffect(Long id, ContestEffectDTO request) {
        return contestEffectRepository.findById(id).map(effect -> {
            effect.setAppeal(request.getAppeal());
            effect.setJam(request.getJam());
            effect.setEffect(request.getEffect());
            effect.setFlavorText(request.getFlavorText());

            ContestEffect updated = contestEffectRepository.save(effect);

            return toDTO(updated);
        });
    }

    @Transactional
    public boolean deleteContestEffect(Long id) {
        if (contestEffectRepository.existsById(id)) {
            contestEffectRepository.deleteById(id);

            return true;
        }

        return false;
    }

    private ContestEffectDTO toDTO(ContestEffect entity) {
        if (entity == null)
            return null;

        return ContestEffectDTO.builder()
            .id(entity.getId())
            .appeal(entity.getAppeal())
            .jam(entity.getJam())
            .effect(entity.getEffect())
            .flavorText(entity.getFlavorText())
            .build();
    }
}
