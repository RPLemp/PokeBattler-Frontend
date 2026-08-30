package de.aix.pokebattler.model.berry;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "berry_firmnesses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BerryFirmness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "firmness")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Berry> berries = new ArrayList<>();
}
