package ru.sfedu.PlanetGame.controllers;

import org.junit.Test;
import ru.sfedu.PlanetGame.models.Resources;
import ru.sfedu.PlanetGame.utils.EntityGenerator;

import java.io.IOException;

import static org.junit.Assert.*;

public class ResourcesControllerTest {
    ResourcesController resourcesController = new ResourcesController();
    @Test
    public void create() throws IOException {
        resourcesController.create(EntityGenerator.generateResources());
    }

    @Test
    public void getAll() throws IOException {
        resourcesController.getAll();
    }

    @Test
    public void getById() throws IOException {
        Resources resources = resourcesController.create(EntityGenerator.generateResources());
        resourcesController.getById(resources.getId());
    }

    @Test
    public void delete() throws IOException {
        Resources resources = resourcesController.create(EntityGenerator.generateResources());
        resourcesController.delete(resources);
    }

    @Test
    public void update() throws IOException {
        Resources resources = resourcesController.create(EntityGenerator.generateResources());
        resources.setMetal(10000);
        resourcesController.update(resources);
    }
}