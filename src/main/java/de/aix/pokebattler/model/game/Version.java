package de.aix.pokebattler.model.game;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "versions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Version {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "version_group_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private VersionGroup versionGroup;
}
