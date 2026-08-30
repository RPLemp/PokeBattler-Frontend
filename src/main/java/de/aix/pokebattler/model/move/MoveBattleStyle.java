package de.aix.pokebattler.model.move;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "move_battle_styles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MoveBattleStyle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
}
