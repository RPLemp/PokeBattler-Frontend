package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.LocationAreaRepository;
import de.aix.pokebattler.model.location.LocationArea;
import de.aix.pokebattler.model.location.LocationAreaDTO;
import de.aix.pokebattler.model.pokemon.Pokemon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocationAreaService {
    private final LocationAreaRepository locationAreaRepository;

    @Transactional(readOnly = true)
    public List<LocationAreaDTO> getAllLocationAreas() {
        return locationAreaRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<LocationAreaDTO> getLocationAreaById(Long id) {
        return locationAreaRepository.findById(id)
            .map(this::toDTO);
    }

    @Transactional
    public LocationAreaDTO createLocationArea(LocationAreaDTO request) {
        LocationArea entity = LocationArea.builder()
            .id(request.getId())
            .name(request.getName())
            .gameIndex(request.getGameIndex())
            .build();

        LocationArea saved = locationAreaRepository.save(entity);

        return toDTO(saved);
    }

    @Transactional
    public Optional<LocationAreaDTO> updateLocationArea(Long id, LocationAreaDTO request) {
        return locationAreaRepository.findById(id).map(area -> {
            area.setName(request.getName());
            area.setGameIndex(request.getGameIndex());

            LocationArea updated = locationAreaRepository.save(area);

            return toDTO(updated);
        });
    }

    @Transactional
    public boolean deleteLocationArea(Long id) {
        if (locationAreaRepository.existsById(id)) {
            locationAreaRepository.deleteById(id);

            return true;
        }

        return false;
    }

    private LocationAreaDTO toDTO(LocationArea entity) {
        if (entity == null)
            return null;

        return LocationAreaDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .gameIndex(entity.getGameIndex())
            .locationId(entity.getLocation() != null ? entity.getLocation().getId() : null)
            .pokemonEncounterIds(entity.getPokemonEncounters() != null ? entity.getPokemonEncounters().stream().map(Pokemon::getId).toList() : null)
            .build();
    }
}
