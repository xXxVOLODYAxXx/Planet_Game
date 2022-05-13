package ru.sfedu.PlanetGame.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)

@Entity
@Table
public class EnemyPlanet extends Planet {
    @Column
    private int enemyHealthPoints;
    @Column
    private int enemyAttackPoints;
}
