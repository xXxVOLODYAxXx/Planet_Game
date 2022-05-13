package ru.sfedu.PlanetGame.controllers;

import org.junit.Test;
import ru.sfedu.PlanetGame.models.Building;
import ru.sfedu.PlanetGame.utils.EntityGenerator;

import java.io.IOException;

import static org.junit.Assert.*;

public class BuildingControllerTest {
    BuildingController buildingController = new BuildingController();

    @Test
    public void create() throws IOException {
        buildingController.create(EntityGenerator.generateBuilding());
    }

    @Test
    public void getAll() throws IOException {
        buildingController.getAll();
    }

    @Test
    public void getById() throws IOException {
        Building building = buildingController.create(EntityGenerator.generateBuilding());
        buildingController.getById(building.getId());
    }

    @Test
    public void delete() throws IOException {
        Building building = buildingController.create(EntityGenerator.generateBuilding());
        buildingController.delete(building);
    }

    @Test
    public void update() throws IOException {
        Building building = buildingController.create(EntityGenerator.generateBuilding());
        buildingController.update(building);
    }
}