package ru.sfedu.PlanetGame.models;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)

@Entity
@Table
public class Building extends Base {
    @Enumerated(EnumType.STRING)
    private BuildingType buildingType;

    @Column
    private int foodBuff;

    @Column
    private int metalBuff;

    @Column
    private int goldBuff;

    @Column
    private int foodCost;

    @Column
    private int metalCost;

    @Column
    private int goldCost;
}
