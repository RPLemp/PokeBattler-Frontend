package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.PalParkAreaRepository;
import de.aix.pokebattler.model.location.PalParkArea;
import de.aix.pokebattler.model.location.PalParkAreaDTO;
import de.aix.pokebattler.model.pokemon.PokemonSpecies;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PalParkAreaService {
    private final PalParkAreaRepository palParkAreaRepository;

    @Transactional(readOnly = true)
    public List<PalParkAreaDTO> getAllPalParkAreas() {
        return palParkAreaRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<PalParkAreaDTO> getPalParkAreaById(Long id) {
        return palParkAreaRepository.findById(id)
            .map(this::toDTO);
    }

    @Transactional
    public PalParkAreaDTO createPalParkArea(PalParkAreaDTO request) {
        PalParkArea entity = PalParkArea.builder()
            .id(request.getId())
            .name(request.getName())
            .build();

        PalParkArea saved = palParkAreaRepository.save(entity);

        return toDTO(saved);
    }

    @Transactional
    public Optional<PalParkAreaDTO> updatePalParkArea(Long id, PalParkAreaDTO request) {
        return palParkAreaRepository.findById(id).map(area -> {
            area.setName(request.getName());
            PalParkArea updated = palParkAreaRepository.save(area);

            return toDTO(updated);
        });
    }

    @Transactional
    public boolean deletePalParkArea(Long id) {
        if (palParkAreaRepository.existsById(id)) {
            palParkAreaRepository.deleteById(id);

            return true;
        }

        return false;
    }

    private PalParkAreaDTO toDTO(PalParkArea entity) {
        if (entity == null)
            return null;

        return PalParkAreaDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .pokemonSpeciesIds(entity.getPokemonSpecies() != null ? entity.getPokemonSpecies().stream().map(PokemonSpecies::getId).toList() : null)
            .build();
    }
}
