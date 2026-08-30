package de.aix.pokebattler.model.item;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pocket_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ItemPocket pocket;

    @OneToMany(mappedBy = "category")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Item> items = new ArrayList<>();
}
