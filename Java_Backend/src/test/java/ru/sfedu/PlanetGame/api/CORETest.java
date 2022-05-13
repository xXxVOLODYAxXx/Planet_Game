package ru.sfedu.PlanetGame.api;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.sfedu.PlanetGame.controllers.GameController;
import ru.sfedu.PlanetGame.models.EnemyPlanet;
import ru.sfedu.PlanetGame.models.Game;
import ru.sfedu.PlanetGame.utils.EntityGenerator;
import java.io.IOException;
import java.sql.SQLException;


import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CORETest {
    CORE core = new CORE();
    GameController gameController = new GameController();

    @Test
    public void createUniverse() throws IOException {
        Game game = EntityGenerator.generateGame();
        game = core.createUniverse(game);
        assertTrue(game.toString().equals(gameController.getById(game.getId()).toString()));
        core.deleteUniverse(game.getId());
    }

    @Test
    public void deleteUniverse() throws IOException {
        Game game = EntityGenerator.generateGame();
        game = core.createUniverse(game);
        assertTrue(game.toString().equals(gameController.getById(game.getId()).toString()));
        core.deleteUniverse(game.getId());
    }

    @Test
    public void getEnemyPower() throws IOException {
        Game game = EntityGenerator.generateGame();
        game = core.createUniverse(game);
        assertTrue(game.toString().equals(gameController.getById(game.getId()).toString()));

        EnemyPlanet enemyPlanet = game.getEnemyPlanetList().get(0);
        assertTrue(enemyPlanet.toString().equals(core.getEnemyPower(game.getEnemyPlanetList().get(0).getId()).toString()));
        core.deleteUniverse(game.getId());
    }

    @Test
    public void getArmyPower() throws IOException {
        Game game = EntityGenerator.generateGame();
        game = core.createUniverse(game);
        assertTrue(game.toString().equals(gameController.getById(game.getId()).toString()));
        assertTrue(game.getResources().getArmy().getArmyInfo().toString().equals(core.getArmyPower(game.getId()).toString()));
        core.deleteUniverse(game.getId());
    }

    @Test
    public void attackPlanet() throws IOException {
        Game game = EntityGenerator.generateGame();
        game = core.createUniverse(game);
        assertTrue(game.toString().equals(gameController.getById(game.getId()).toString()));

        core.attackPlanet(game.getEnemyPlanetList().get(0).getId(),game.getId());
        core.deleteUniverse(game.getId());
    }

    @Test
    public void hireUnit() throws IOException, SQLException {
        Game game = EntityGenerator.generateGame();
        game = core.createUniverse(game);
        assertTrue(game.toString().equals(gameController.getById(game.getId()).toString()));
        assertNotEquals(game.getResources().getArmy().getUnits().toString(), core.hireUnit(1L, game).getResources().getArmy().getUnits().toString());
        //core.deleteUniverse(game.getId());
    }

    @Test
    public void getBuildingsInfo() throws IOException {
        Game game = EntityGenerator.generateGame();
        game = core.createUniverse(game);
        assertTrue(game.toString().equals(gameController.getById(game.getId()).toString()));
        assertTrue(game.getResources().getBuildingList().toString().equals(core.getBuildingsInfo(game.getId()).toString()));
    }

    @Test
    public void addBuilding() throws IOException, SQLException {
        Game game = EntityGenerator.generateGame();
        game = core.createUniverse(game);
        assertTrue(game.toString().equals(gameController.getById(game.getId()).toString()));
        Assertions.assertFalse(game.getResources().getBuildingList().toString().equals(core.addBuilding(1L, game).getResources().getBuildingList().toString()));
    }

    @Test
    public void removeBuilding() throws IOException, SQLException {
        Game game = EntityGenerator.generateGame();
        game = core.createUniverse(game);
        assertTrue(game.toString().equals(gameController.getById(game.getId()).toString()));
        Assertions.assertFalse(game.getResources().getBuildingList().toString().equals(core.addBuilding(1L, game).getResources().getBuildingList().toString()));
        Assertions.assertFalse(game.getResources().getBuildingList().toString().equals(core.removeBuilding(1L, game.getId()).getResources().getBuildingList().toString()));
    }

    @Test
    public void manageResources() throws IOException {
        Game game = EntityGenerator.generateGame();
        game = core.createUniverse(game);
        assertTrue(game.toString().equals(gameController.getById(game.getId()).toString()));
    }

    @Test
    public void testManageResources() throws IOException {
        Game game = EntityGenerator.generateGame();
        game = core.createUniverse(game);
        assertTrue(game.toString().equals(gameController.getById(game.getId()).toString()));
        assertEquals(game.getResources().getBuildingList().toString(), core.manageResources(game.getId(), 1).getResources().getBuildingList().toString());
    }

    @Test
    public void getBuildingById() {

    }

    @Test
    public void getUnitById() {

    }
}