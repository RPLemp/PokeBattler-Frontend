package de.aix.pokebattler.model.location;

import de.aix.pokebattler.model.pokemon.PokemonSpecies;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pal_park_areas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PalParkArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany
    @JoinTable(
        name = "pal_park_area_species",
        joinColumns = @JoinColumn(name = "pal_park_area_id"),
        inverseJoinColumns = @JoinColumn(name = "species_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<PokemonSpecies> pokemonSpecies = new ArrayList<>();
}
