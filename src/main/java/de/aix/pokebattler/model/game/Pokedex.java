package de.aix.pokebattler.model.game;

import de.aix.pokebattler.model.location.Region;
import de.aix.pokebattler.model.pokemon.PokemonSpecies;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pokedexes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pokedex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private Boolean isMainSeries;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Region region;

    @ManyToMany(mappedBy = "pokedexes")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<VersionGroup> versionGroups = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "pokedex_pokemon_species",
        joinColumns = @JoinColumn(name = "pokedex_id"),
        inverseJoinColumns = @JoinColumn(name = "species_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<PokemonSpecies> pokemonSpecies = new ArrayList<>();
}
