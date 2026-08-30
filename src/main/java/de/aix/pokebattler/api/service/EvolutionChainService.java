package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.EvolutionChainRepository;
import de.aix.pokebattler.model.evolution.EvolutionChain;
import de.aix.pokebattler.model.evolution.EvolutionChainDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EvolutionChainService {
    private final EvolutionChainRepository evolutionChainRepository;

    @Transactional(readOnly = true)
    public List<EvolutionChainDTO> getAllEvolutionChains() {
        return evolutionChainRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<EvolutionChainDTO> getEvolutionChainById(Long id) {
        return evolutionChainRepository.findById(id)
            .map(this::toDTO);
    }

    @Transactional
    public EvolutionChainDTO createEvolutionChain(EvolutionChainDTO request) {
        EvolutionChain entity = EvolutionChain.builder()
            .id(request.getId())
            .build();

        EvolutionChain saved = evolutionChainRepository.save(entity);

        return toDTO(saved);
    }

    @Transactional
    public Optional<EvolutionChainDTO> updateEvolutionChain(Long id, EvolutionChainDTO request) {
        return evolutionChainRepository.findById(id).map(chain -> {
            EvolutionChain updated = evolutionChainRepository.save(chain);

            return toDTO(updated);
        });
    }

    @Transactional
    public boolean deleteEvolutionChain(Long id) {
        if (evolutionChainRepository.existsById(id)) {
            evolutionChainRepository.deleteById(id);

            return true;
        }

        return false;
    }

    private EvolutionChainDTO toDTO(EvolutionChain entity) {
        if (entity == null)
            return null;

        return EvolutionChainDTO.builder()
            .id(entity.getId())
            .babyTriggerItemId(entity.getBabyTriggerItem() != null ? entity.getBabyTriggerItem().getId() : null)
            .build();
    }
}
