package de.aix.pokebattler.model.pokemon;

import de.aix.pokebattler.model.game.Generation;
import de.aix.pokebattler.model.move.Move;
import de.aix.pokebattler.model.move.MoveDamageClass;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "types")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "generation_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Generation generation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "move_damage_class_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private MoveDamageClass moveDamageClass;

    @ManyToMany(mappedBy = "types")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Pokemon> pokemon = new ArrayList<>();

    @OneToMany(mappedBy = "type")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Move> moves = new ArrayList<>();
}
