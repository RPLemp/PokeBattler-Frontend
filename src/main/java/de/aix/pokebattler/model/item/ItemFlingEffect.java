package de.aix.pokebattler.model.item;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item_fling_effects")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemFlingEffect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "flingEffect")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Item> items = new ArrayList<>();
}
