package ru.sfedu.PlanetGame.controllers;

import ru.sfedu.PlanetGame.api.CRUD;
import ru.sfedu.PlanetGame.models.Resources;

import java.io.IOException;
import java.util.List;

public class ResourcesController {
    private CRUD crud = new CRUD();

    public Resources create(Resources resources) throws IOException {
        return crud.create(resources);
    }

    public List<Resources> getAll() throws IOException {
        return crud.getAll(Resources.class);
    }

    public Resources getById(long id) throws IOException {
        return crud.getById(id, Resources.class);
    }

    public void delete(Resources resources) throws IOException {
        crud.delete(resources);
    }

    public Resources update(Resources resources) throws IOException {
        return crud.update(resources);
    }
}
