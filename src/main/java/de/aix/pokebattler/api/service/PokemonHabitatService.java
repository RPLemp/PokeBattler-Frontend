package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.PokemonHabitatRepository;
import de.aix.pokebattler.model.pokemon.PokemonHabitat;
import de.aix.pokebattler.model.pokemon.PokemonHabitatDTO;
import de.aix.pokebattler.model.pokemon.PokemonSpecies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonHabitatService {
    private final PokemonHabitatRepository pokemonHabitatRepository;

    public PokemonHabitatService(PokemonHabitatRepository pokemonHabitatRepository) {
        this.pokemonHabitatRepository = pokemonHabitatRepository;
    }

    public List<PokemonHabitatDTO> getAllPokemonHabitats() {
        return pokemonHabitatRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    public Optional<PokemonHabitatDTO> getPokemonHabitatById(Long id) {
        return pokemonHabitatRepository.findById(id)
            .map(this::toDTO);
    }

    public Optional<PokemonHabitatDTO> getPokemonHabitatByName(String name) {
        return pokemonHabitatRepository.findByNameIgnoreCase(name)
            .map(this::toDTO);
    }

    private PokemonHabitatDTO toDTO(PokemonHabitat entity) {
        if (entity == null)
            return null;

        return PokemonHabitatDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .pokemonSpeciesIds(entity.getPokemonSpecies() != null
                    ? entity.getPokemonSpecies().stream().map(PokemonSpecies::getId).toList()
                    : null)
            .build();
    }
}
