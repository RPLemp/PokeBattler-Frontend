package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.PokemonRepository;
import de.aix.pokebattler.model.item.Item;
import de.aix.pokebattler.model.move.Move;
import de.aix.pokebattler.model.pokemon.Ability;
import de.aix.pokebattler.model.pokemon.Pokemon;
import de.aix.pokebattler.model.pokemon.PokemonDTO;
import de.aix.pokebattler.model.pokemon.PokemonForm;
import de.aix.pokebattler.model.pokemon.Stat;
import de.aix.pokebattler.model.pokemon.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PokemonService {
    private final PokemonRepository pokemonRepository;

    @Transactional(readOnly = true)
    public List<PokemonDTO> getAllPokemons() {
        return pokemonRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<PokemonDTO> getPokemonById(Long id) {
        return pokemonRepository.findById(id)
            .map(this::toDTO);
    }

    @Transactional
    public PokemonDTO createPokemon(PokemonDTO request) {
        Pokemon entity = Pokemon.builder()
            .id(request.getId())
            .name(request.getName())
            .baseExperience(request.getBaseExperience())
            .height(request.getHeight())
            .isDefault(request.getIsDefault())
            .order(request.getOrder())
            .weight(request.getWeight())
            .build();

        Pokemon saved = pokemonRepository.save(entity);

        return toDTO(saved);
    }

    @Transactional
    public Optional<PokemonDTO> updatePokemon(Long id, PokemonDTO request) {
        return pokemonRepository.findById(id).map(pokemon -> {
            pokemon.setName(request.getName());
            pokemon.setBaseExperience(request.getBaseExperience());
            pokemon.setHeight(request.getHeight());
            pokemon.setIsDefault(request.getIsDefault());
            pokemon.setOrder(request.getOrder());
            pokemon.setWeight(request.getWeight());
            Pokemon updated = pokemonRepository.save(pokemon);

            return toDTO(updated);
        });
    }

    @Transactional
    public boolean deletePokemon(Long id) {
        if (pokemonRepository.existsById(id)) {
            pokemonRepository.deleteById(id);

            return true;
        }

        return false;
    }

    private PokemonDTO toDTO(Pokemon pokemon) {
        if (pokemon == null)
            return null;

        return PokemonDTO.builder()
            .id(pokemon.getId())
            .name(pokemon.getName())
            .baseExperience(pokemon.getBaseExperience())
            .height(pokemon.getHeight())
            .isDefault(pokemon.getIsDefault())
            .order(pokemon.getOrder())
            .weight(pokemon.getWeight())
            .speciesId(pokemon.getSpecies() != null ? pokemon.getSpecies().getId() : null)
            .abilityIds(pokemon.getAbilities() != null ? pokemon.getAbilities().stream().map(Ability::getId).toList() : null)
            .typeIds(pokemon.getTypes() != null ? pokemon.getTypes().stream().map(Type::getId).toList() : null)
            .formIds(pokemon.getForms() != null ? pokemon.getForms().stream().map(PokemonForm::getId).toList() : null)
            .moveIds(pokemon.getMoves() != null ? pokemon.getMoves().stream().map(Move::getId).toList() : null)
            .statIds(pokemon.getStats() != null ? pokemon.getStats().stream().map(Stat::getId).toList() : null)
            .heldItemIds(pokemon.getHeldItems() != null ? pokemon.getHeldItems().stream().map(Item::getId).toList() : null)
            .build();
    }
}
