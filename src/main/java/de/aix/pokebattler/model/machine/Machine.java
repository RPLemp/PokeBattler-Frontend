package de.aix.pokebattler.model.machine;

import de.aix.pokebattler.model.game.VersionGroup;
import de.aix.pokebattler.model.item.Item;
import de.aix.pokebattler.model.move.Move;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "machines")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "move_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Move move;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "version_group_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private VersionGroup versionGroup;
}
