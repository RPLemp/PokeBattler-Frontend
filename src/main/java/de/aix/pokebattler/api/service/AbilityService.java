package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.AbilityRepository;
import de.aix.pokebattler.model.pokemon.Ability;
import de.aix.pokebattler.model.pokemon.AbilityDTO;
import de.aix.pokebattler.model.pokemon.Pokemon;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbilityService {
    private final AbilityRepository abilityRepository;

    public AbilityService(AbilityRepository abilityRepository) {
        this.abilityRepository = abilityRepository;
    }

    public List<AbilityDTO> getAllAbilities() {
        return abilityRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    public Optional<AbilityDTO> getAbilityById(Long id) {
        return abilityRepository.findById(id)
            .map(this::toDTO);
    }

    public Optional<AbilityDTO> getAbilityByName(String name) {
        return abilityRepository.findByNameIgnoreCase(name)
            .map(this::toDTO);
    }

    private AbilityDTO toDTO(Ability entity) {
        if (entity == null)
            return null;

        return AbilityDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .isMainSeries(entity.getIsMainSeries())
            .generationId(entity.getGeneration() != null ? entity.getGeneration().getId() : null)
            .pokemonIds(entity.getPokemon() != null
                    ? entity.getPokemon().stream().map(Pokemon::getId).toList()
                    : null)
            .build();
    }
}
