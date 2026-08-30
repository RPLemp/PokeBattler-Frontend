package de.aix.pokebattler.model.location;

import de.aix.pokebattler.model.pokemon.Pokemon;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "location_areas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private Integer gameIndex;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Location location;

    @ManyToMany
    @JoinTable(
        name = "location_area_pokemon_encounters",
        joinColumns = @JoinColumn(name = "location_area_id"),
        inverseJoinColumns = @JoinColumn(name = "pokemon_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Pokemon> pokemonEncounters = new ArrayList<>();
}
