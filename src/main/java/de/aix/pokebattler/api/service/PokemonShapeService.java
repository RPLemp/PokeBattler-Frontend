package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.PokemonShapeRepository;
import de.aix.pokebattler.model.pokemon.PokemonShape;
import de.aix.pokebattler.model.pokemon.PokemonShapeDTO;
import de.aix.pokebattler.model.pokemon.PokemonSpecies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonShapeService {
    private final PokemonShapeRepository pokemonShapeRepository;

    public PokemonShapeService(PokemonShapeRepository pokemonShapeRepository) {
        this.pokemonShapeRepository = pokemonShapeRepository;
    }

    public List<PokemonShapeDTO> getAllPokemonShapes() {
        return pokemonShapeRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    public Optional<PokemonShapeDTO> getPokemonShapeById(Long id) {
        return pokemonShapeRepository.findById(id)
            .map(this::toDTO);
    }

    public Optional<PokemonShapeDTO> getPokemonShapeByName(String name) {
        return pokemonShapeRepository.findByNameIgnoreCase(name)
            .map(this::toDTO);
    }

    private PokemonShapeDTO toDTO(PokemonShape entity) {
        if (entity == null)
            return null;

        return PokemonShapeDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .pokemonSpeciesIds(entity.getPokemonSpecies() != null
                    ? entity.getPokemonSpecies().stream().map(PokemonSpecies::getId).toList()
                    : null)
            .build();
    }
}
