package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.EggGroupRepository;
import de.aix.pokebattler.model.pokemon.EggGroup;
import de.aix.pokebattler.model.pokemon.EggGroupDTO;
import de.aix.pokebattler.model.pokemon.PokemonSpecies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EggGroupService {
    private final EggGroupRepository eggGroupRepository;

    public EggGroupService(EggGroupRepository eggGroupRepository) {
        this.eggGroupRepository = eggGroupRepository;
    }

    public List<EggGroupDTO> getAllEggGroups() {
        return eggGroupRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    public Optional<EggGroupDTO> getEggGroupById(Long id) {
        return eggGroupRepository.findById(id)
            .map(this::toDTO);
    }

    public Optional<EggGroupDTO> getEggGroupByName(String name) {
        return eggGroupRepository.findByNameIgnoreCase(name)
            .map(this::toDTO);
    }

    private EggGroupDTO toDTO(EggGroup entity) {
        if (entity == null)
            return null;

        return EggGroupDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .pokemonSpeciesIds(entity.getPokemonSpecies() != null
                    ? entity.getPokemonSpecies().stream().map(PokemonSpecies::getId).toList()
                    : null)
            .build();
    }
}
