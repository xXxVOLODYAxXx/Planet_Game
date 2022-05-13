package ru.sfedu.PlanetGame.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)

@MappedSuperclass
public abstract class Planet extends Base {
    @Column
    private String planetName;
    
    @Column
    private String type;
}
