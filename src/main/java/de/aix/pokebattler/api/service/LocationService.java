package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.LocationRepository;
import de.aix.pokebattler.model.location.Location;
import de.aix.pokebattler.model.location.LocationArea;
import de.aix.pokebattler.model.location.LocationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    @Transactional(readOnly = true)
    public List<LocationDTO> getAllLocations() {
        return locationRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<LocationDTO> getLocationById(Long id) {
        return locationRepository.findById(id)
            .map(this::toDTO);
    }

    @Transactional
    public LocationDTO createLocation(LocationDTO request) {
        Location entity = Location.builder()
            .id(request.getId())
            .name(request.getName())
            .build();

        Location saved = locationRepository.save(entity);

        return toDTO(saved);
    }

    @Transactional
    public Optional<LocationDTO> updateLocation(Long id, LocationDTO request) {
        return locationRepository.findById(id).map(location -> {
            location.setName(request.getName());
            Location updated = locationRepository.save(location);

            return toDTO(updated);
        });
    }

    @Transactional
    public boolean deleteLocation(Long id) {
        if (locationRepository.existsById(id)) {
            locationRepository.deleteById(id);

            return true;
        }

        return false;
    }

    private LocationDTO toDTO(Location entity) {
        if (entity == null)
            return null;

        return LocationDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .regionId(entity.getRegion() != null ? entity.getRegion().getId() : null)
            .areaIds(entity.getAreas() != null ? entity.getAreas().stream().map(LocationArea::getId).toList() : null)
            .build();
    }
}
