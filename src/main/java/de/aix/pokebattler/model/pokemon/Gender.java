package de.aix.pokebattler.model.pokemon;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany
    @JoinTable(
        name = "gender_pokemon_species",
        joinColumns = @JoinColumn(name = "gender_id"),
        inverseJoinColumns = @JoinColumn(name = "species_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<PokemonSpecies> pokemonSpecies = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "gender_evolution_species",
        joinColumns = @JoinColumn(name = "gender_id"),
        inverseJoinColumns = @JoinColumn(name = "species_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<PokemonSpecies> requiredForEvolution = new ArrayList<>();
}
