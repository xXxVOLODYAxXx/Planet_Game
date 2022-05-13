package ru.sfedu.PlanetGame.controllers;

import ru.sfedu.PlanetGame.api.CRUD;
import ru.sfedu.PlanetGame.models.Unit;

import java.io.IOException;
import java.util.List;

public class UnitController {
    private CRUD crud = new CRUD();

    public Unit create(Unit unit) throws IOException {
        return crud.create(unit);
    }

    public List<Unit> getAll() throws IOException {
        return crud.getAll(Unit.class);
    }

    public Unit getById(long id) throws IOException {
        return crud.getById(id, Unit.class);
    }

    public void delete(Unit unit) throws IOException {
        crud.delete(unit);
    }

    public Unit update(Unit unit) throws IOException {
        return crud.update(unit);
    }
}
