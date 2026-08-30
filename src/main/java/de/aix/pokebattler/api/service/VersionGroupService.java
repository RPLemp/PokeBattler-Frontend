package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.VersionGroupRepository;
import de.aix.pokebattler.model.game.Pokedex;
import de.aix.pokebattler.model.game.Version;
import de.aix.pokebattler.model.game.VersionGroup;
import de.aix.pokebattler.model.game.VersionGroupDTO;
import de.aix.pokebattler.model.location.Region;
import de.aix.pokebattler.model.move.MoveLearnMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VersionGroupService {
    private final VersionGroupRepository versionGroupRepository;

    @Transactional(readOnly = true)
    public List<VersionGroupDTO> getAllVersionGroups() {
        return versionGroupRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<VersionGroupDTO> getVersionGroupById(Long id) {
        return versionGroupRepository.findById(id)
            .map(this::toDTO);
    }

    @Transactional
    public VersionGroupDTO createVersionGroup(VersionGroupDTO request) {
        VersionGroup entity = VersionGroup.builder()
            .id(request.getId())
            .name(request.getName())
            .order(request.getOrder())
            .build();

        VersionGroup saved = versionGroupRepository.save(entity);

        return toDTO(saved);
    }

    @Transactional
    public Optional<VersionGroupDTO> updateVersionGroup(Long id, VersionGroupDTO request) {
        return versionGroupRepository.findById(id).map(vg -> {
            vg.setName(request.getName());
            vg.setOrder(request.getOrder());

            VersionGroup updated = versionGroupRepository.save(vg);

            return toDTO(updated);
        });
    }

    @Transactional
    public boolean deleteVersionGroup(Long id) {
        if (versionGroupRepository.existsById(id)) {
            versionGroupRepository.deleteById(id);

            return true;
        }

        return false;
    }

    private VersionGroupDTO toDTO(VersionGroup entity) {
        if (entity == null)
            return null;

        return VersionGroupDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .order(entity.getOrder())
            .generationId(entity.getGeneration() != null ? entity.getGeneration().getId() : null)
            .moveLearnMethodIds(entity.getMoveLearnMethods() != null ? entity.getMoveLearnMethods().stream().map(MoveLearnMethod::getId).toList() : null)
            .pokedexIds(entity.getPokedexes() != null ? entity.getPokedexes().stream().map(Pokedex::getId).toList() : null)
            .regionIds(entity.getRegions() != null ? entity.getRegions().stream().map(Region::getId).toList() : null)
            .versionIds(entity.getVersions() != null ? entity.getVersions().stream().map(Version::getId).toList() : null)
            .build();
    }
}
