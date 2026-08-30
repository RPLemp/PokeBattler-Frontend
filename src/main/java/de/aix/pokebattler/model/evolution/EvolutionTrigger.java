package de.aix.pokebattler.model.evolution;

import de.aix.pokebattler.model.pokemon.PokemonSpecies;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "evolution_triggers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvolutionTrigger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany
    @JoinTable(
        name = "evolution_trigger_species",
        joinColumns = @JoinColumn(name = "trigger_id"),
        inverseJoinColumns = @JoinColumn(name = "species_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<PokemonSpecies> pokemonSpecies = new ArrayList<>();
}
