package ru.sfedu.PlanetGame.controllers;

import org.junit.Test;
import ru.sfedu.PlanetGame.models.ArmyInfo;
import ru.sfedu.PlanetGame.utils.EntityGenerator;

import java.io.IOException;

import static org.junit.Assert.*;

public class ArmyInfoControllerTest {
    ArmyInfoController armyInfoController = new ArmyInfoController();

    @Test
    public void create() throws IOException {
        armyInfoController.create(EntityGenerator.generateArmyInfo());
    }

    @Test
    public void getAll() throws IOException {
        armyInfoController.getAll();
    }

    @Test
    public void getById() throws IOException {
        ArmyInfo armyInfo = armyInfoController.create(EntityGenerator.generateArmyInfo());
        armyInfoController.getById(armyInfo.getId());
    }

    @Test
    public void delete() throws IOException {
        ArmyInfo armyInfo = armyInfoController.create(EntityGenerator.generateArmyInfo());
        armyInfoController.delete(armyInfo);
    }

    @Test
    public void update() throws IOException {
        ArmyInfo armyInfo = armyInfoController.create(EntityGenerator.generateArmyInfo());
        armyInfoController.update(armyInfo);
    }
}