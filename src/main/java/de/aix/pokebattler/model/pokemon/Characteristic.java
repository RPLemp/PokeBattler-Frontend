package de.aix.pokebattler.model.pokemon;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "characteristics")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Characteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer geneModulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "highest_stat_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Stat highestStat;
}
