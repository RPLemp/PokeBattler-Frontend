package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.StatRepository;
import de.aix.pokebattler.model.pokemon.Pokemon;
import de.aix.pokebattler.model.pokemon.Stat;
import de.aix.pokebattler.model.pokemon.StatDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatService {
    private final StatRepository statRepository;

    public StatService(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    public List<StatDTO> getAllStats() {
        return statRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    public Optional<StatDTO> getStatById(Long id) {
        return statRepository.findById(id)
            .map(this::toDTO);
    }

    public Optional<StatDTO> getStatByName(String name) {
        return statRepository.findByNameIgnoreCase(name)
            .map(this::toDTO);
    }

    public StatDTO toDTO(Stat stat) {
        if (stat == null)
            return null;

        StatDTO dto = new StatDTO();
        dto.setId(stat.getId());
        dto.setName(stat.getName());
        dto.setGameIndex(stat.getGameIndex());
        dto.setIsBattleOnly(stat.getIsBattleOnly());

        if (stat.getMoveDamageClass() != null)
            dto.setMoveDamageClassId(stat.getMoveDamageClass().getId());

        if (stat.getPokemon() != null)
            dto.setPokemonIds(stat.getPokemon().stream().map(Pokemon::getId).toList());

        return dto;
    }
}
