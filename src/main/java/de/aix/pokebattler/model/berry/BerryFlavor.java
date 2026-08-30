package de.aix.pokebattler.model.berry;

import de.aix.pokebattler.model.contest.ContestType;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "berry_flavors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BerryFlavor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contest_type_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ContestType contestType;

    @ManyToMany(mappedBy = "flavors")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Berry> berries = new ArrayList<>();
}
