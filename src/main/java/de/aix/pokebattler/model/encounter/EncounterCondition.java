package de.aix.pokebattler.model.encounter;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "encounter_conditions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EncounterCondition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "condition", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<EncounterConditionValue> values = new ArrayList<>();
}
