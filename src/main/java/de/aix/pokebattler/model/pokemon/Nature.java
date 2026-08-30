package de.aix.pokebattler.model.pokemon;

import de.aix.pokebattler.model.berry.BerryFlavor;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "natures")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Nature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "decreased_stat_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Stat decreasedStat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "increased_stat_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Stat increasedStat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hates_flavor_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private BerryFlavor hatesFlavor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "likes_flavor_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private BerryFlavor likesFlavor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pokeathlon_stat_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private PokeathlonStat pokeathlonStat;
}
