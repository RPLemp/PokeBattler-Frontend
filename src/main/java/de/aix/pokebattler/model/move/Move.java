package de.aix.pokebattler.model.move;

import de.aix.pokebattler.model.contest.ContestEffect;
import de.aix.pokebattler.model.contest.ContestType;
import de.aix.pokebattler.model.contest.SuperContestEffect;
import de.aix.pokebattler.model.game.Generation;
import de.aix.pokebattler.model.pokemon.Pokemon;
import de.aix.pokebattler.model.pokemon.Type;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "moves")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Move {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private Integer accuracy;

    private Integer effectChance;

    private Integer pp;

    private Integer priority;

    private Integer power;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contest_type_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ContestType contestType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contest_effect_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ContestEffect contestEffect;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "super_contest_effect_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private SuperContestEffect superContestEffect;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "damage_class_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private MoveDamageClass damageClass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "generation_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Generation generation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private MoveTarget target;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ailment_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private MoveAilment ailment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private MoveCategory category;

    @ManyToMany(mappedBy = "moves")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Pokemon> learnedByPokemon = new ArrayList<>();
}
