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
public class ArmyInfo extends Base {
    @Column
    private int totalHealth;

    @Column
    private int totalDamage;
}
