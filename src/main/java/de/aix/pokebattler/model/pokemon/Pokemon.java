package de.aix.pokebattler.model.pokemon;

import de.aix.pokebattler.model.item.Item;
import de.aix.pokebattler.model.move.Move;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pokemon")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Integer baseExperience;

    private Integer height;

    private Boolean isDefault;

    @Column(name = "order_index")
    private Integer order;

    private Integer weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "species_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private PokemonSpecies species;

    @ManyToMany
    @JoinTable(
        name = "pokemon_abilities",
        joinColumns = @JoinColumn(name = "pokemon_id"),
        inverseJoinColumns = @JoinColumn(name = "ability_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Ability> abilities = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "pokemon_types",
        joinColumns = @JoinColumn(name = "pokemon_id"),
        inverseJoinColumns = @JoinColumn(name = "type_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Type> types = new ArrayList<>();

    @OneToMany(mappedBy = "pokemon")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<PokemonForm> forms = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "pokemon_moves",
        joinColumns = @JoinColumn(name = "pokemon_id"),
        inverseJoinColumns = @JoinColumn(name = "move_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Move> moves = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "pokemon_stats",
        joinColumns = @JoinColumn(name = "pokemon_id"),
        inverseJoinColumns = @JoinColumn(name = "stat_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Stat> stats = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "pokemon_held_items",
        joinColumns = @JoinColumn(name = "pokemon_id"),
        inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Item> heldItems = new ArrayList<>();

    public Pokemon(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
