package ru.sfedu.PlanetGame.controllers;

import org.junit.Test;
import ru.sfedu.PlanetGame.models.PlayerPlanet;
import ru.sfedu.PlanetGame.utils.EntityGenerator;

import java.io.IOException;

import static org.junit.Assert.*;

public class PlayerPlanetControllerTest {
    PlayerPlanetController playerPlanetController = new PlayerPlanetController();
    @Test
    public void create() throws IOException {
        playerPlanetController.create(EntityGenerator.generatePlayerPlanet());
    }

    @Test
    public void getAll() throws IOException {
        playerPlanetController.getAll();
    }

    @Test
    public void getById() throws IOException {
        PlayerPlanet playerPlanet = playerPlanetController.create(EntityGenerator.generatePlayerPlanet());
        playerPlanetController.getById(playerPlanet.getId());
    }

    @Test
    public void delete() throws IOException {
        PlayerPlanet playerPlanet = playerPlanetController.create(EntityGenerator.generatePlayerPlanet());
        playerPlanetController.delete(playerPlanet);
    }

    @Test
    public void update() throws IOException {
        PlayerPlanet playerPlanet = playerPlanetController.create(EntityGenerator.generatePlayerPlanet());
        playerPlanetController.update(playerPlanet);
    }
}