package ru.sfedu.PlanetGame.controllers;

import ru.sfedu.PlanetGame.api.CRUD;
import ru.sfedu.PlanetGame.models.ArmyInfo;

import java.io.IOException;
import java.util.List;

public class ArmyInfoController {
    private CRUD crud = new CRUD();

    public ArmyInfo create(ArmyInfo armyInfo) throws IOException {
        return crud.create(armyInfo);
    }

    public List<ArmyInfo> getAll() throws IOException {
        return crud.getAll(ArmyInfo.class);
    }

    public ArmyInfo getById(long id) throws IOException {
        return crud.getById(id, ArmyInfo.class);
    }

    public void delete(ArmyInfo armyInfo) throws IOException {
        crud.delete(armyInfo);
    }

    public ArmyInfo update(ArmyInfo armyInfo) throws IOException {
        return crud.update(armyInfo);
    }
}
