package de.aix.pokebattler.model.contest;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contest_effects")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContestEffect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer appeal;

    private Integer jam;

    @Column(length = 1000)
    private String effect;

    @Column(length = 1000)
    private String flavorText;
}
