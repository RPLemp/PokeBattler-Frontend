package de.aix.pokebattler.model.pokemon;

import de.aix.pokebattler.model.game.Generation;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "abilities")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private Boolean isMainSeries;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "generation_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Generation generation;

    @ManyToMany(mappedBy = "abilities")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Pokemon> pokemon = new ArrayList<>();
}
