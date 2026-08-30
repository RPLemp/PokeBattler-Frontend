package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.PokedexRepository;
import de.aix.pokebattler.model.game.Pokedex;
import de.aix.pokebattler.model.game.PokedexDTO;
import de.aix.pokebattler.model.game.VersionGroup;
import de.aix.pokebattler.model.pokemon.PokemonSpecies;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PokedexService {
    private final PokedexRepository pokedexRepository;

    @Transactional(readOnly = true)
    public List<PokedexDTO> getAllPokedexes() {
        return pokedexRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<PokedexDTO> getPokedexById(Long id) {
        return pokedexRepository.findById(id)
            .map(this::toDTO);
    }

    @Transactional
    public PokedexDTO createPokedex(PokedexDTO request) {
        Pokedex entity = Pokedex.builder()
            .id(request.getId())
            .name(request.getName())
            .isMainSeries(request.getIsMainSeries())
            .build();

        Pokedex saved = pokedexRepository.save(entity);

        return toDTO(saved);
    }

    @Transactional
    public Optional<PokedexDTO> updatePokedex(Long id, PokedexDTO request) {
        return pokedexRepository.findById(id).map(pokedex -> {
            pokedex.setName(request.getName());
            pokedex.setIsMainSeries(request.getIsMainSeries());
            Pokedex updated = pokedexRepository.save(pokedex);

            return toDTO(updated);
        });
    }

    @Transactional
    public boolean deletePokedex(Long id) {
        if (pokedexRepository.existsById(id)) {
            pokedexRepository.deleteById(id);

            return true;
        }

        return false;
    }

    private PokedexDTO toDTO(Pokedex entity) {
        if (entity == null)
            return null;

        return PokedexDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .isMainSeries(entity.getIsMainSeries())
            .regionId(entity.getRegion() != null ? entity.getRegion().getId() : null)
            .versionGroupIds(entity.getVersionGroups() != null ? entity.getVersionGroups().stream().map(VersionGroup::getId).toList() : null)
            .pokemonSpeciesIds(entity.getPokemonSpecies() != null ? entity.getPokemonSpecies().stream().map(PokemonSpecies::getId).toList() : null)
            .build();
    }
}
