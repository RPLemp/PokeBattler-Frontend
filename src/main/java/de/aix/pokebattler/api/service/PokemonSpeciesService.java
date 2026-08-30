package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.PokemonSpeciesRepository;
import de.aix.pokebattler.model.pokemon.EggGroup;
import de.aix.pokebattler.model.pokemon.Pokemon;
import de.aix.pokebattler.model.pokemon.PokemonSpecies;
import de.aix.pokebattler.model.pokemon.PokemonSpeciesDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonSpeciesService {
    private final PokemonSpeciesRepository pokemonSpeciesRepository;

    public PokemonSpeciesService(PokemonSpeciesRepository pokemonSpeciesRepository) {
        this.pokemonSpeciesRepository = pokemonSpeciesRepository;
    }

    public List<PokemonSpeciesDTO> getAllPokemonSpecies() {
        return pokemonSpeciesRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    public Optional<PokemonSpeciesDTO> getPokemonSpeciesById(Long id) {
        return pokemonSpeciesRepository.findById(id)
            .map(this::toDTO);
    }

    public Optional<PokemonSpeciesDTO> getPokemonSpeciesByName(String name) {
        return pokemonSpeciesRepository.findByNameIgnoreCase(name)
            .map(this::toDTO);
    }

    public PokemonSpeciesDTO toDTO(PokemonSpecies pokemonSpecies) {
        if (pokemonSpecies == null)
            return null;

        PokemonSpeciesDTO dto = new PokemonSpeciesDTO();
        dto.setId(pokemonSpecies.getId());
        dto.setName(pokemonSpecies.getName());
        dto.setOrder(pokemonSpecies.getOrder());
        dto.setGenderRate(pokemonSpecies.getGenderRate());
        dto.setCaptureRate(pokemonSpecies.getCaptureRate());
        dto.setBaseHappiness(pokemonSpecies.getBaseHappiness());
        dto.setIsBaby(pokemonSpecies.getIsBaby());
        dto.setIsLegendary(pokemonSpecies.getIsLegendary());
        dto.setIsMythical(pokemonSpecies.getIsMythical());
        dto.setHatchCounter(pokemonSpecies.getHatchCounter());
        dto.setHasGenderDifferences(pokemonSpecies.getHasGenderDifferences());
        dto.setFormsSwitchable(pokemonSpecies.getFormsSwitchable());

        if (pokemonSpecies.getGrowthRate() != null)
            dto.setGrowthRateId(pokemonSpecies.getGrowthRate().getId());

        if (pokemonSpecies.getEggGroups() != null)
            dto.setEggGroupIds(pokemonSpecies.getEggGroups().stream().map(EggGroup::getId).toList());

        if (pokemonSpecies.getColor() != null)
            dto.setColorId(pokemonSpecies.getColor().getId());

        if (pokemonSpecies.getShape() != null)
            dto.setShapeId(pokemonSpecies.getShape().getId());

        if (pokemonSpecies.getEvolvesFromSpecies() != null)
            dto.setEvolvesFromSpeciesId(pokemonSpecies.getEvolvesFromSpecies().getId());

        if (pokemonSpecies.getEvolutionChain() != null)
            dto.setEvolutionChainId(pokemonSpecies.getEvolutionChain().getId());

        if (pokemonSpecies.getHabitat() != null)
            dto.setHabitatId(pokemonSpecies.getHabitat().getId());

        if (pokemonSpecies.getGeneration() != null)
            dto.setGenerationId(pokemonSpecies.getGeneration().getId());

        if (pokemonSpecies.getVarieties() != null)
            dto.setVarietyPokemonIds(pokemonSpecies.getVarieties().stream().map(Pokemon::getId).toList());

        return dto;
    }
}