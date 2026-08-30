package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.GrowthRateRepository;
import de.aix.pokebattler.model.pokemon.GrowthRate;
import de.aix.pokebattler.model.pokemon.GrowthRateDTO;
import de.aix.pokebattler.model.pokemon.PokemonSpecies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrowthRateService {
    private final GrowthRateRepository growthRateRepository;

    public GrowthRateService(GrowthRateRepository growthRateRepository) {
        this.growthRateRepository = growthRateRepository;
    }

    public List<GrowthRateDTO> getAllGrowthRates() {
        return growthRateRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    public Optional<GrowthRateDTO> getGrowthRateById(Long id) {
        return growthRateRepository.findById(id)
            .map(this::toDTO);
    }

    public Optional<GrowthRateDTO> getGrowthRateByName(String name) {
        return growthRateRepository.findByNameIgnoreCase(name)
            .map(this::toDTO);
    }

    private GrowthRateDTO toDTO(GrowthRate entity) {
        if (entity == null)
            return null;

        return GrowthRateDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .formula(entity.getFormula())
            .pokemonSpeciesIds(entity.getPokemonSpecies() != null
                    ? entity.getPokemonSpecies().stream().map(PokemonSpecies::getId).toList()
                    : null)
            .build();
    }
}
