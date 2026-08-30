package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.PokemonColorRepository;
import de.aix.pokebattler.model.pokemon.PokemonColor;
import de.aix.pokebattler.model.pokemon.PokemonColorDTO;
import de.aix.pokebattler.model.pokemon.PokemonSpecies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonColorService {
    private final PokemonColorRepository pokemonColorRepository;

    public PokemonColorService(PokemonColorRepository pokemonColorRepository) {
        this.pokemonColorRepository = pokemonColorRepository;
    }

    public List<PokemonColorDTO> getAllPokemonColors() {
        return pokemonColorRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    public Optional<PokemonColorDTO> getPokemonColorById(Long id) {
        return pokemonColorRepository.findById(id)
            .map(this::toDTO);
    }

    public Optional<PokemonColorDTO> getPokemonColorByName(String name) {
        return pokemonColorRepository.findByNameIgnoreCase(name)
            .map(this::toDTO);
    }

    private PokemonColorDTO toDTO(PokemonColor entity) {
        if (entity == null)
            return null;

        return PokemonColorDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .pokemonSpeciesIds(entity.getPokemonSpecies() != null
                    ? entity.getPokemonSpecies().stream().map(PokemonSpecies::getId).toList()
                    : null)
            .build();
    }
}
