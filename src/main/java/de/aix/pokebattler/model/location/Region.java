package de.aix.pokebattler.model.location;

import de.aix.pokebattler.model.game.Generation;
import de.aix.pokebattler.model.game.Pokedex;
import de.aix.pokebattler.model.game.VersionGroup;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "regions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "main_generation_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Generation mainGeneration;

    @OneToMany(mappedBy = "region")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Location> locations = new ArrayList<>();

    @OneToMany(mappedBy = "region")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Pokedex> pokedexes = new ArrayList<>();

    @ManyToMany(mappedBy = "regions")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<VersionGroup> versionGroups = new ArrayList<>();
}
