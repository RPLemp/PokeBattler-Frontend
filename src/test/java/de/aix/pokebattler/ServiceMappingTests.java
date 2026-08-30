package de.aix.pokebattler;

import de.aix.pokebattler.api.repository.*;
import de.aix.pokebattler.api.service.*;
import de.aix.pokebattler.model.berry.Berry;
import de.aix.pokebattler.model.berry.BerryDTO;
import de.aix.pokebattler.model.berry.BerryFirmness;
import de.aix.pokebattler.model.berry.BerryFlavor;
import de.aix.pokebattler.model.item.Item;
import de.aix.pokebattler.model.pokemon.Pokemon;
import de.aix.pokebattler.model.pokemon.PokemonDTO;
import de.aix.pokebattler.model.pokemon.PokemonSpecies;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ServiceMappingTests {

    @Mock
    private BerryRepository berryRepository;

    @InjectMocks
    private BerryService berryService;

    @Mock
    private PokemonRepository pokemonRepository;

    @InjectMocks
    private PokemonService pokemonService;

    @Test
    void testBerryMapping() {
        BerryFirmness firmness = BerryFirmness.builder().id(2L).name("hard").build();
        BerryFlavor flavor = BerryFlavor.builder().id(3L).name("spicy").build();
        Item item = Item.builder().id(10L).name("cheri-berry").build();

        Berry berry = Berry.builder()
                .id(1L)
                .name("cheri")
                .growthTime(3)
                .maxHarvest(5)
                .naturalGiftPower(60)
                .size(20)
                .smoothness(25)
                .soilDryness(15)
                .firmness(firmness)
                .flavors(List.of(flavor))
                .item(item)
                .build();

        when(berryRepository.findById(1L)).thenReturn(Optional.of(berry));

        Optional<BerryDTO> result = berryService.getBerryById(1L);

        assertTrue(result.isPresent());
        BerryDTO dto = result.get();
        assertEquals(1L, dto.getId());
        assertEquals("cheri", dto.getName());
        assertEquals(2L, dto.getFirmnessId());
        assertEquals(10L, dto.getItemId());
        assertEquals(List.of(3L), dto.getFlavorIds());
    }

    @Test
    void testPokemonMapping() {
        PokemonSpecies species = PokemonSpecies.builder().id(5L).name("pikachu").build();
        Pokemon pokemon = Pokemon.builder()
                .id(25L)
                .name("pikachu")
                .baseExperience(112)
                .height(4)
                .weight(60)
                .order(35)
                .isDefault(true)
                .species(species)
                .build();

        when(pokemonRepository.findById(25L)).thenReturn(Optional.of(pokemon));

        Optional<PokemonDTO> result = pokemonService.getPokemonById(25L);

        assertTrue(result.isPresent());
        PokemonDTO dto = result.get();
        assertEquals(25L, dto.getId());
        assertEquals("pikachu", dto.getName());
        assertEquals(5L, dto.getSpeciesId());
        assertTrue(dto.getIsDefault());
    }
}
