package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.PokemonFormRepository;
import de.aix.pokebattler.model.pokemon.PokemonForm;
import de.aix.pokebattler.model.pokemon.PokemonFormDTO;
import de.aix.pokebattler.model.pokemon.Type;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonFormService {
    private final PokemonFormRepository pokemonFormRepository;

    public PokemonFormService(PokemonFormRepository pokemonFormRepository) {
        this.pokemonFormRepository = pokemonFormRepository;
    }

    public List<PokemonFormDTO> getAllPokemonForms() {
        return pokemonFormRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    public Optional<PokemonFormDTO> getPokemonFormById(Long id) {
        return pokemonFormRepository.findById(id)
            .map(this::toDTO);
    }

    public Optional<PokemonFormDTO> getPokemonFormByName(String name) {
        return pokemonFormRepository.findByNameIgnoreCase(name)
            .map(this::toDTO);
    }

    private PokemonFormDTO toDTO(PokemonForm entity) {
        if (entity == null)
            return null;

        return PokemonFormDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .order(entity.getOrder())
            .formOrder(entity.getFormOrder())
            .isDefault(entity.getIsDefault())
            .isBattleOnly(entity.getIsBattleOnly())
            .isMega(entity.getIsMega())
            .formName(entity.getFormName())
            .pokemonId(entity.getPokemon() != null ? entity.getPokemon().getId() : null)
            .versionGroupId(entity.getVersionGroup() != null ? entity.getVersionGroup().getId() : null)
            .typeIds(entity.getTypes() != null
                    ? entity.getTypes().stream().map(Type::getId).toList()
                    : null)
            .build();
}
}
