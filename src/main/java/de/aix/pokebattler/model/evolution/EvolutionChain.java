package de.aix.pokebattler.model.evolution;

import de.aix.pokebattler.model.item.Item;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "evolution_chains")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvolutionChain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_trigger_item_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Item babyTriggerItem;
}
