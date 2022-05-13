package ru.sfedu.PlanetGame.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor

@Entity
@Table
public class Army extends Base {
    @Column
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Unit> units = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ArmyInfo armyInfo;
}
