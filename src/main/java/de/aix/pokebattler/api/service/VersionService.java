package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.VersionRepository;
import de.aix.pokebattler.model.game.Version;
import de.aix.pokebattler.model.game.VersionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VersionService {
    private final VersionRepository versionRepository;

    @Transactional(readOnly = true)
    public List<VersionDTO> getAllVersions() {
        return versionRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<VersionDTO> getVersionById(Long id) {
        return versionRepository.findById(id)
            .map(this::toDTO);
    }

    @Transactional
    public VersionDTO createVersion(VersionDTO request) {
        Version entity = Version.builder()
            .id(request.getId())
            .name(request.getName())
            .build();

        Version saved = versionRepository.save(entity);

        return toDTO(saved);
    }

    @Transactional
    public Optional<VersionDTO> updateVersion(Long id, VersionDTO request) {
        return versionRepository.findById(id).map(version -> {
            version.setName(request.getName());

            Version updated = versionRepository.save(version);

            return toDTO(updated);
        });
    }

    @Transactional
    public boolean deleteVersion(Long id) {
        if (versionRepository.existsById(id)) {
            versionRepository.deleteById(id);

            return true;
        }

        return false;
    }

    private VersionDTO toDTO(Version entity) {
        if (entity == null)
            return null;

        return VersionDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .versionGroupId(entity.getVersionGroup() != null ? entity.getVersionGroup().getId() : null)
            .build();
    }
}
