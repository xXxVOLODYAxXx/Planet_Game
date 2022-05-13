package ru.sfedu.PlanetGame.controllers;

import org.junit.Test;
import ru.sfedu.PlanetGame.models.Game;
import ru.sfedu.PlanetGame.utils.EntityGenerator;

import java.io.IOException;

import static org.junit.Assert.*;

public class GameControllerTest {
    GameController gameController = new GameController();
    @Test
    public void create() throws IOException {
        gameController.create(EntityGenerator.generateGame());
    }

    @Test
    public void getAll() throws IOException {
        gameController.getAll();
    }

    @Test
    public void getById() throws IOException {
        Game game = gameController.create(EntityGenerator.generateGame());
        gameController.getById(game.getId());
    }

    @Test
    public void delete() throws IOException {
        Game game = gameController.create(EntityGenerator.generateGame());
        gameController.delete(game);
    }

    @Test
    public void update() throws IOException {
        Game game = gameController.create(EntityGenerator.generateGame());
        gameController.update(game);
    }
}