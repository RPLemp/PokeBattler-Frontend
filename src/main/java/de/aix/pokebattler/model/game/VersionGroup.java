package de.aix.pokebattler.model.game;

import de.aix.pokebattler.model.location.Region;
import de.aix.pokebattler.model.move.MoveLearnMethod;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "version_groups")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VersionGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "order_index")
    private Integer order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "generation_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Generation generation;

    @ManyToMany
    @JoinTable(
        name = "version_group_move_learn_methods",
        joinColumns = @JoinColumn(name = "version_group_id"),
        inverseJoinColumns = @JoinColumn(name = "move_learn_method_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<MoveLearnMethod> moveLearnMethods = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "version_group_pokedexes",
        joinColumns = @JoinColumn(name = "version_group_id"),
        inverseJoinColumns = @JoinColumn(name = "pokedex_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Pokedex> pokedexes = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "version_group_regions",
        joinColumns = @JoinColumn(name = "version_group_id"),
        inverseJoinColumns = @JoinColumn(name = "region_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Region> regions = new ArrayList<>();

    @OneToMany(mappedBy = "versionGroup")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Version> versions = new ArrayList<>();
}
