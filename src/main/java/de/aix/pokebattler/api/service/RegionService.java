package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.RegionRepository;
import de.aix.pokebattler.model.game.Pokedex;
import de.aix.pokebattler.model.game.VersionGroup;
import de.aix.pokebattler.model.location.Location;
import de.aix.pokebattler.model.location.Region;
import de.aix.pokebattler.model.location.RegionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegionService {
    private final RegionRepository regionRepository;

    @Transactional(readOnly = true)
    public List<RegionDTO> getAllRegions() {
        return regionRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<RegionDTO> getRegionById(Long id) {
        return regionRepository.findById(id)
            .map(this::toDTO);
    }

    @Transactional
    public RegionDTO createRegion(RegionDTO request) {
        Region entity = Region.builder()
            .id(request.getId())
            .name(request.getName())
            .build();

        Region saved = regionRepository.save(entity);

        return toDTO(saved);
    }

    @Transactional
    public Optional<RegionDTO> updateRegion(Long id, RegionDTO request) {
        return regionRepository.findById(id).map(region -> {
            region.setName(request.getName());
            Region updated = regionRepository.save(region);

            return toDTO(updated);
        });
    }

    @Transactional
    public boolean deleteRegion(Long id) {
        if (regionRepository.existsById(id)) {
            regionRepository.deleteById(id);

            return true;
        }

        return false;
    }

    private RegionDTO toDTO(Region entity) {
        if (entity == null)
            return null;

        return RegionDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .mainGenerationId(entity.getMainGeneration() != null ? entity.getMainGeneration().getId() : null)
            .locationIds(entity.getLocations() != null ? entity.getLocations().stream().map(Location::getId).toList() : null)
            .pokedexIds(entity.getPokedexes() != null ? entity.getPokedexes().stream().map(Pokedex::getId).toList() : null)
            .versionGroupIds(entity.getVersionGroups() != null ? entity.getVersionGroups().stream().map(VersionGroup::getId).toList() : null)
            .build();
    }
}
