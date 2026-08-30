package de.aix.pokebattler.model.pokemon;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pokemon_shapes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PokemonShape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "shape")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<PokemonSpecies> pokemonSpecies = new ArrayList<>();
}
