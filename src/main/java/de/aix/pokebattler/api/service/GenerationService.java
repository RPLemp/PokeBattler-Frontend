package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.GenerationRepository;
import de.aix.pokebattler.model.game.Generation;
import de.aix.pokebattler.model.game.GenerationDTO;
import de.aix.pokebattler.model.game.VersionGroup;
import de.aix.pokebattler.model.move.Move;
import de.aix.pokebattler.model.pokemon.Ability;
import de.aix.pokebattler.model.pokemon.PokemonSpecies;
import de.aix.pokebattler.model.pokemon.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenerationService {
    private final GenerationRepository generationRepository;

    @Transactional(readOnly = true)
    public List<GenerationDTO> getAllGenerations() {
        return generationRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<GenerationDTO> getGenerationById(Long id) {
        return generationRepository.findById(id)
            .map(this::toDTO);
    }

    @Transactional
    public GenerationDTO createGeneration(GenerationDTO request) {
        Generation entity = Generation.builder()
            .id(request.getId())
            .name(request.getName())
            .build();

        Generation saved = generationRepository.save(entity);

        return toDTO(saved);
    }

    @Transactional
    public Optional<GenerationDTO> updateGeneration(Long id, GenerationDTO request) {
        return generationRepository.findById(id).map(generation -> {
            generation.setName(request.getName());
            Generation updated = generationRepository.save(generation);

            return toDTO(updated);
        });
    }

    @Transactional
    public boolean deleteGeneration(Long id) {
        if (generationRepository.existsById(id)) {
            generationRepository.deleteById(id);

            return true;
        }

        return false;
    }

    private GenerationDTO toDTO(Generation entity) {
        if (entity == null)
            return null;

        return GenerationDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .mainRegionId(entity.getMainRegion() != null ? entity.getMainRegion().getId() : null)
            .abilityIds(entity.getAbilities() != null ? entity.getAbilities().stream().map(Ability::getId).toList() : null)
            .moveIds(entity.getMoves() != null ? entity.getMoves().stream().map(Move::getId).toList() : null)
            .pokemonSpeciesIds(entity.getPokemonSpecies() != null ? entity.getPokemonSpecies().stream().map(PokemonSpecies::getId).toList() : null)
            .typeIds(entity.getTypes() != null ? entity.getTypes().stream().map(Type::getId).toList() : null)
            .versionGroupIds(entity.getVersionGroups() != null ? entity.getVersionGroups().stream().map(VersionGroup::getId).toList() : null)
            .build();
    }
}
