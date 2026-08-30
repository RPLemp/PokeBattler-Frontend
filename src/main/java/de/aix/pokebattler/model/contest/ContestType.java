package de.aix.pokebattler.model.contest;

import de.aix.pokebattler.model.berry.BerryFlavor;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contest_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContestType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "berry_flavor_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private BerryFlavor berryFlavor;
}
