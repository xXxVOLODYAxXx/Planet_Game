package ru.sfedu.PlanetGame.controllers;

import ru.sfedu.PlanetGame.api.CRUD;
import ru.sfedu.PlanetGame.models.Army;

import java.io.IOException;
import java.util.List;

public class ArmyController {
    private CRUD crud = new CRUD();

    public Army create(Army army) throws IOException {
        return crud.create(army);
    }

    public List<Army> getAll() throws IOException {
        return crud.getAll(Army.class);
    }

    public Army getById(long id) throws IOException {
        return crud.getById(id, Army.class);
    }

    public void delete(Army army) throws IOException {
        crud.delete(army);
    }

    public Army update(Army army) throws IOException {
        return crud.update(army);
    }
}
