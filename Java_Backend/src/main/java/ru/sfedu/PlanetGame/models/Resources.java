package ru.sfedu.PlanetGame.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)

@Entity
@Table
public class Resources extends Base {
    @Column
    private int food;

    @Column
    private int metal;

    @Column
    private int gold;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Army army;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Building> buildingList;

    @Column
    private int operation;
}
