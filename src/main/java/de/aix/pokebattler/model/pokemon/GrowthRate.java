package de.aix.pokebattler.model.pokemon;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "growth_rates")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GrowthRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(length = 1000)
    private String formula;

    @OneToMany(mappedBy = "growthRate")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<PokemonSpecies> pokemonSpecies = new ArrayList<>();
}
