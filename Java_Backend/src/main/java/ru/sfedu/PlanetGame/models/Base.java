package ru.sfedu.PlanetGame.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@EqualsAndHashCode
@ToString

@MappedSuperclass
public abstract class Base {
    @Id
    @GeneratedValue(generator = "increment")
    private Long id;

//    @Column
//    private Date dateCreate;
//
//    @Column
//    private Date dateUpdate;

    public Base() {
    }
}
