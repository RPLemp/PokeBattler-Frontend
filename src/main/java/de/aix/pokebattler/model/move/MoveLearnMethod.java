package de.aix.pokebattler.model.move;

import de.aix.pokebattler.model.game.VersionGroup;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "move_learn_methods")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MoveLearnMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "moveLearnMethods")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<VersionGroup> versionGroups = new ArrayList<>();
}
