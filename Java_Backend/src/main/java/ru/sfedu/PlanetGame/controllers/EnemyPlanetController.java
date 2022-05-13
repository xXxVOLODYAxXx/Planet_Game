package ru.sfedu.PlanetGame.controllers;

import ru.sfedu.PlanetGame.api.CRUD;
import ru.sfedu.PlanetGame.models.EnemyPlanet;

import java.io.IOException;
import java.util.List;

public class EnemyPlanetController {
    private CRUD crud = new CRUD();

    public EnemyPlanet create(EnemyPlanet enemyPlanet) throws IOException {
        return crud.create(enemyPlanet);
    }

    public List<EnemyPlanet> getAll() throws IOException {
        return crud.getAll(EnemyPlanet.class);
    }

    public EnemyPlanet getById(long id) throws IOException {
        return crud.getById(id, EnemyPlanet.class);
    }

    public void delete(EnemyPlanet enemyPlanet) throws IOException {
        crud.delete(enemyPlanet);
    }

    public EnemyPlanet update(EnemyPlanet enemyPlanet) throws IOException {
        return crud.update(enemyPlanet);
    }
}
