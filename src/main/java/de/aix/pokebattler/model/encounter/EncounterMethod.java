package de.aix.pokebattler.model.encounter;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "encounter_methods")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EncounterMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "order_index")
    private Integer order;
}
