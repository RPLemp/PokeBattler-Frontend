package de.aix.pokebattler.model.move;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "move_damage_classes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MoveDamageClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "damageClass")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Move> moves = new ArrayList<>();
}
