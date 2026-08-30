package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.PokeathlonStatRepository;
import de.aix.pokebattler.model.pokemon.Nature;
import de.aix.pokebattler.model.pokemon.PokeathlonStat;
import de.aix.pokebattler.model.pokemon.PokeathlonStatDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokeathlonStatService {
    private final PokeathlonStatRepository pokeathlonStatRepository;

    public PokeathlonStatService(PokeathlonStatRepository pokeathlonStatRepository) {
        this.pokeathlonStatRepository = pokeathlonStatRepository;
    }

    public List<PokeathlonStatDTO> getAllPokeathlonStats() {
        return pokeathlonStatRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    public Optional<PokeathlonStatDTO> getPokeathlonStatById(Long id) {
        return pokeathlonStatRepository.findById(id)
            .map(this::toDTO);
    }

    public Optional<PokeathlonStatDTO> getPokeathlonStatByName(String name) {
        return pokeathlonStatRepository.findByNameIgnoreCase(name)
            .map(this::toDTO);
    }

    private PokeathlonStatDTO toDTO(PokeathlonStat entity) {
        if (entity == null)
            return null;

        return PokeathlonStatDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .affectingNatureIds(entity.getAffectingNatures() != null
                    ? entity.getAffectingNatures().stream().map(Nature::getId).toList()
                    : null)
            .build();
    }
}
