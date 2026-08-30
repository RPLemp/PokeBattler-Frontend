package de.aix.pokebattler.model.berry;

import de.aix.pokebattler.model.item.Item;
import de.aix.pokebattler.model.pokemon.Type;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "berries")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Berry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private Integer growthTime;

    private Integer maxHarvest;

    private Integer naturalGiftPower;

    private Integer size;

    private Integer smoothness;

    private Integer soilDryness;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "firmness_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private BerryFirmness firmness;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "natural_gift_type_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Type naturalGiftType;

    @ManyToMany
    @JoinTable(
        name = "berry_flavor_mappings",
        joinColumns = @JoinColumn(name = "berry_id"),
        inverseJoinColumns = @JoinColumn(name = "flavor_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<BerryFlavor> flavors = new ArrayList<>();
}
