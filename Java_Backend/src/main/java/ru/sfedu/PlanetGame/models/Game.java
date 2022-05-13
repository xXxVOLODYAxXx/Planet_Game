package ru.sfedu.PlanetGame.models;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)

@Entity
@Table
public class Game extends Base {
    @Column
    private String title;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<EnemyPlanet> enemyPlanetList;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PlayerPlanet> playerPlanetList;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Resources resources;

    private String telegramId;
}
