package ru.sfedu.PlanetGame.controllers;

import ru.sfedu.PlanetGame.api.CRUD;
import ru.sfedu.PlanetGame.models.PlayerPlanet;

import java.io.IOException;
import java.util.List;

public class PlayerPlanetController {
    private CRUD crud = new CRUD();

    public PlayerPlanet create(PlayerPlanet playerPlanet) throws IOException {
        return crud.create(playerPlanet);
    }

    public List<PlayerPlanet> getAll() throws IOException {
        return crud.getAll(PlayerPlanet.class);
    }

    public PlayerPlanet getById(long id) throws IOException {
        return crud.getById(id, PlayerPlanet.class);
    }

    public void delete(PlayerPlanet playerPlanet) throws IOException {
        crud.delete(playerPlanet);
    }

    public PlayerPlanet update(PlayerPlanet playerPlanet) throws IOException {
        return crud.update(playerPlanet);
    }
}
