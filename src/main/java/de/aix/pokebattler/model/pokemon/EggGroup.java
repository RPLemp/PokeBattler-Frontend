package de.aix.pokebattler.model.pokemon;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "egg_groups")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EggGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "eggGroups")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<PokemonSpecies> pokemonSpecies = new ArrayList<>();
}
