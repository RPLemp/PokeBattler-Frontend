package de.aix.pokebattler;

import de.aix.pokebattler.api.controller.BerryController;
import de.aix.pokebattler.api.controller.PokemonController;
import de.aix.pokebattler.api.service.BerryService;
import de.aix.pokebattler.api.service.PokemonService;
import de.aix.pokebattler.model.berry.BerryDTO;
import de.aix.pokebattler.model.pokemon.PokemonDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ControllerTests {

    @Mock
    private PokemonService pokemonService;

    @InjectMocks
    private PokemonController pokemonController;

    @Mock
    private BerryService berryService;

    @InjectMocks
    private BerryController berryController;

    @Test
    void testGetPokemonById() {
        PokemonDTO dto = PokemonDTO.builder().id(25L).name("pikachu").build();
        when(pokemonService.getPokemonById(25L)).thenReturn(Optional.of(dto));

        ResponseEntity<PokemonDTO> response = pokemonController.getPokemonById(25L);

        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals("pikachu", response.getBody().getName());
    }

    @Test
    void testGetPokemonById_NotFound() {
        when(pokemonService.getPokemonById(999L)).thenReturn(Optional.empty());

        ResponseEntity<PokemonDTO> response = pokemonController.getPokemonById(999L);

        assertEquals(404, response.getStatusCode().value());
    }

    @Test
    void testGetAllBerries() {
        BerryDTO berry = BerryDTO.builder().id(1L).name("cheri").build();
        when(berryService.getAllBerries()).thenReturn(List.of(berry));

        ResponseEntity<List<BerryDTO>> response = berryController.getAllBerries();

        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        assertEquals("cheri", response.getBody().getFirst().getName());
    }
}
