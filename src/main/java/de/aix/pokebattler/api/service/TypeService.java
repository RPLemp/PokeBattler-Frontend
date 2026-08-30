package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.TypeRepository;
import de.aix.pokebattler.model.move.Move;
import de.aix.pokebattler.model.pokemon.Pokemon;
import de.aix.pokebattler.model.pokemon.Type;
import de.aix.pokebattler.model.pokemon.TypeDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService {
    private final TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<TypeDTO> getAllTypes() {
        return typeRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    public Optional<TypeDTO> getTypeById(Long id) {
        return typeRepository.findById(id)
            .map(this::toDTO);
    }

    public Optional<TypeDTO> getTypeByName(String name) {
        return typeRepository.findByNameIgnoreCase(name)
            .map(this::toDTO);
    }

    public TypeDTO toDTO(Type type) {
        if (type == null)
            return null;

        TypeDTO dto = new TypeDTO();
        dto.setId(type.getId());
        dto.setName(type.getName());

        if (type.getGeneration() != null)
            dto.setGenerationId(type.getGeneration().getId());

        if (type.getMoveDamageClass() != null)
            dto.setMoveDamageClassId(type.getMoveDamageClass().getId());

        if (type.getPokemon() != null)
            dto.setPokemonIds(type.getPokemon().stream().map(Pokemon::getId).toList());

        if (type.getMoves() != null)
            dto.setMoveIds(type.getMoves().stream().map(Move::getId).toList());

        return dto;
    }
}
