package de.aix.pokebattler.model.pokemon;

import de.aix.pokebattler.model.evolution.EvolutionChain;
import de.aix.pokebattler.model.game.Generation;
import de.aix.pokebattler.model.game.Pokedex;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pokemon_species")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PokemonSpecies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "order_index")
    private Integer order;

    private Integer genderRate;

    private Integer captureRate;

    private Integer baseHappiness;

    private Boolean isBaby;

    private Boolean isLegendary;

    private Boolean isMythical;

    private Integer hatchCounter;

    private Boolean hasGenderDifferences;

    private Boolean formsSwitchable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "growth_rate_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private GrowthRate growthRate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private PokemonColor color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shape_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private PokemonShape shape;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evolves_from_species_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private PokemonSpecies evolvesFromSpecies;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evolution_chain_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private EvolutionChain evolutionChain;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "habitat_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private PokemonHabitat habitat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "generation_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Generation generation;

    @ManyToMany
    @JoinTable(
        name = "pokemon_species_egg_groups",
        joinColumns = @JoinColumn(name = "species_id"),
        inverseJoinColumns = @JoinColumn(name = "egg_group_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<EggGroup> eggGroups = new ArrayList<>();

    @ManyToMany(mappedBy = "pokemonSpecies")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Pokedex> pokedexes = new ArrayList<>();

    @OneToMany(mappedBy = "species")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Pokemon> varieties = new ArrayList<>();
}
