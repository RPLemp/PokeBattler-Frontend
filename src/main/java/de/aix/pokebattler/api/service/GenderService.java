package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.GenderRepository;
import de.aix.pokebattler.model.pokemon.Gender;
import de.aix.pokebattler.model.pokemon.GenderDTO;
import de.aix.pokebattler.model.pokemon.PokemonSpecies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderService {
    private final GenderRepository genderRepository;

    public GenderService(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    public List<GenderDTO> getAllGenders() {
        return genderRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    public Optional<GenderDTO> getGenderById(Long id) {
        return genderRepository.findById(id)
            .map(this::toDTO);
    }

    public Optional<GenderDTO> getGenderByName(String name) {
        return genderRepository.findByNameIgnoreCase(name)
            .map(this::toDTO);
    }

    private GenderDTO toDTO(Gender entity) {
        if (entity == null)
            return null;

        return GenderDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .pokemonSpeciesIds(entity.getPokemonSpecies() != null
                    ? entity.getPokemonSpecies().stream().map(PokemonSpecies::getId).toList()
                    : null)
            .requiredForEvolutionIds(entity.getRequiredForEvolution() != null
                    ? entity.getRequiredForEvolution().stream().map(PokemonSpecies::getId).toList()
                    : null)
            .build();
    }
}
