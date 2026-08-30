package de.aix.pokebattler.model.item;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item_pockets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemPocket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "pocket")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<ItemCategory> categories = new ArrayList<>();
}
