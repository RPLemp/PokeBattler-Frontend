package de.aix.pokebattler.model.item;

import de.aix.pokebattler.model.evolution.EvolutionChain;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private Integer cost;

    private Integer flingPower;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fling_effect_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ItemFlingEffect flingEffect;

    @ManyToMany
    @JoinTable(
        name = "item_attribute_mappings",
        joinColumns = @JoinColumn(name = "item_id"),
        inverseJoinColumns = @JoinColumn(name = "attribute_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<ItemAttribute> attributes = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ItemCategory category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_trigger_for_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private EvolutionChain babyTriggerFor;
}
