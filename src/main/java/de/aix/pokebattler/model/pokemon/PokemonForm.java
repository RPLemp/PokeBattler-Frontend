package de.aix.pokebattler.model.pokemon;

import de.aix.pokebattler.model.game.VersionGroup;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pokemon_forms")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PokemonForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "order_index")
    private Integer order;

    private Integer formOrder;

    private Boolean isDefault;

    private Boolean isBattleOnly;

    private Boolean isMega;

    private String formName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pokemon_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Pokemon pokemon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "version_group_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private VersionGroup versionGroup;

    @ManyToMany
    @JoinTable(
        name = "pokemon_form_types",
        joinColumns = @JoinColumn(name = "pokemon_form_id"),
        inverseJoinColumns = @JoinColumn(name = "type_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Type> types = new ArrayList<>();
}
