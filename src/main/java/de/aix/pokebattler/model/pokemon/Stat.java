package de.aix.pokebattler.model.pokemon;

import de.aix.pokebattler.model.move.MoveDamageClass;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stats")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private Integer gameIndex;

    private Boolean isBattleOnly;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "move_damage_class_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private MoveDamageClass moveDamageClass;

    @ManyToMany(mappedBy = "stats")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Pokemon> pokemon = new ArrayList<>();
}
