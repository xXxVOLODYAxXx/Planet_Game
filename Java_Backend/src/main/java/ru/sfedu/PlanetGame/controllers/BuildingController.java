package ru.sfedu.PlanetGame.controllers;

import ru.sfedu.PlanetGame.api.CRUD;
import ru.sfedu.PlanetGame.models.Building;

import java.io.IOException;
import java.util.List;

public class BuildingController {
    private CRUD crud = new CRUD();

    public Building create(Building building) throws IOException {
        return crud.create(building);
    }

    public List<Building> getAll() throws IOException {
        return crud.getAll(Building.class);
    }

    public Building getById(long id) throws IOException {
        return crud.getById(id, Building.class);
    }

    public void delete(Building building) throws IOException {
        crud.delete(building);
    }

    public Building update(Building building) throws IOException {
        return crud.update(building);
    }
}
