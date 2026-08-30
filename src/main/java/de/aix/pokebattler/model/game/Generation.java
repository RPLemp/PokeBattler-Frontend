package de.aix.pokebattler.model.game;

import de.aix.pokebattler.model.location.Region;
import de.aix.pokebattler.model.move.Move;
import de.aix.pokebattler.model.pokemon.Ability;
import de.aix.pokebattler.model.pokemon.PokemonSpecies;
import de.aix.pokebattler.model.pokemon.Type;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "generations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Generation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "main_region_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Region mainRegion;

    @OneToMany(mappedBy = "generation")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Ability> abilities = new ArrayList<>();

    @OneToMany(mappedBy = "generation")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Move> moves = new ArrayList<>();

    @OneToMany(mappedBy = "generation")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<PokemonSpecies> pokemonSpecies = new ArrayList<>();

    @OneToMany(mappedBy = "generation")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Type> types = new ArrayList<>();

    @OneToMany(mappedBy = "generation")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<VersionGroup> versionGroups = new ArrayList<>();
}
