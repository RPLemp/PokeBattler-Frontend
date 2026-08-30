package de.aix.pokebattler.model.location;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "locations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Region region;

    @OneToMany(mappedBy = "location")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<LocationArea> areas = new ArrayList<>();
}
