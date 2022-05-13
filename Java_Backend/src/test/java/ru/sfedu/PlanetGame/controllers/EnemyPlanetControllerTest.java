package ru.sfedu.PlanetGame.controllers;

import org.junit.Test;
import ru.sfedu.PlanetGame.models.EnemyPlanet;
import ru.sfedu.PlanetGame.utils.EntityGenerator;

import java.io.IOException;

import static org.junit.Assert.*;

public class EnemyPlanetControllerTest {
    EnemyPlanetController enemyPlanetController = new EnemyPlanetController();

    @Test
    public void create() throws IOException {
        enemyPlanetController.create(EntityGenerator.generateEnemyPlanet());
    }

    @Test
    public void getAll() throws IOException {
        enemyPlanetController.getAll();
    }

    @Test
    public void getById() throws IOException {
        EnemyPlanet enemyPlanet = enemyPlanetController.create(EntityGenerator.generateEnemyPlanet());
        enemyPlanetController.getById(enemyPlanet.getId());
    }

    @Test
    public void delete() throws IOException {
        EnemyPlanet enemyPlanet = enemyPlanetController.create(EntityGenerator.generateEnemyPlanet());
        enemyPlanetController.delete(enemyPlanet);
    }

    @Test
    public void update() throws IOException {
        EnemyPlanet enemyPlanet = enemyPlanetController.create(EntityGenerator.generateEnemyPlanet());
        enemyPlanetController.update(enemyPlanet);
    }
}