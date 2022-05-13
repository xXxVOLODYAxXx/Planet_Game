package ru.sfedu.PlanetGame.controllers;

import org.junit.Test;
import ru.sfedu.PlanetGame.models.Army;
import ru.sfedu.PlanetGame.models.ArmyInfo;
import ru.sfedu.PlanetGame.models.Unit;
import ru.sfedu.PlanetGame.utils.EntityGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ArmyControllerTest {

    UnitController unitController = new UnitController();
    ArmyInfoController armyInfoController = new ArmyInfoController();
    ArmyController armyController = new ArmyController();

    @Test
    public void create() throws IOException {
        armyController.create(EntityGenerator.generateArmy());
    }

    @Test
    public void getAll() throws IOException {
        armyController.getAll();
    }

    @Test
    public void getById() throws IOException {
        Army army = armyController.create(EntityGenerator.generateArmy());
        armyController.getById(army.getId());
    }

    @Test
    public void delete() throws IOException {
        Army army = armyController.create(EntityGenerator.generateArmy());
        armyController.delete(army);
    }

    @Test
    public void update() throws IOException {
        Army army = armyController.create(EntityGenerator.generateArmy());
        army.getArmyInfo().setTotalDamage(5000);
        armyController.update(army);
    }
}