package de.aix.pokebattler.model.contest;

import de.aix.pokebattler.model.move.Move;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "super_contest_effects")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SuperContestEffect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer appeal;

    @Column(length = 1000)
    private String flavorText;

    @OneToMany(mappedBy = "superContestEffect")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Move> moves = new ArrayList<>();
}
