package de.aix.pokebattler.model.move;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "move_ailments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MoveAilment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "ailment")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Move> moves = new ArrayList<>();
}
