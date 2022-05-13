package ru.sfedu.PlanetGame.controllers;

import org.junit.Test;
import ru.sfedu.PlanetGame.api.CRUD;
import ru.sfedu.PlanetGame.models.Unit;
import ru.sfedu.PlanetGame.utils.EntityGenerator;

import java.io.IOException;

import static org.junit.Assert.*;

public class UnitControllerTest {
    UnitController unitController = new UnitController();

    @Test
    public void create() throws IOException {
        unitController.create(EntityGenerator.generateUnit());
    }

    @Test
    public void getAll() throws IOException {
        unitController.getAll();
    }

    @Test
    public void getById() throws IOException {
        Unit unit = unitController.create(EntityGenerator.generateUnit());
        unitController.getById(unit.getId());
    }

    @Test
    public void delete() throws IOException {
        Unit unit = unitController.create(EntityGenerator.generateUnit());
        unitController.delete(unit);
    }

    @Test
    public void update() throws IOException {
        Unit unit = unitController.create(EntityGenerator.generateUnit());
        unit.setUnitAttackPoints(1000);
        unitController.update(unit);
    }
}