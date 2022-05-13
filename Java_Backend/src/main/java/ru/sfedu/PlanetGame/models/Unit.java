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
public class Unit extends Base {
    @Enumerated(EnumType.STRING)
    private UnitType unitType;
    
    @Column
    private int unitAttackPoints;
    
    @Column
    private int unitHealthPoints;
    
    @Column
    private int goldRequired;
    
    @Column
    private int metalRequired;
    
    @Column
    private int foodRequired;

}

