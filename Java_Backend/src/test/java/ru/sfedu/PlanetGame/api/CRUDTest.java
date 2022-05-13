package ru.sfedu.PlanetGame.api;

import org.junit.Test;
import ru.sfedu.PlanetGame.models.*;
import ru.sfedu.PlanetGame.utils.EntityGenerator;

import java.io.IOException;
import java.util.List;

public class CRUDTest {

    CRUD crud = new CRUD();
    Game game = EntityGenerator.generateGame();
    @Test
    public void create() throws IOException {

        System.out.println(crud.create(game));
    }

    @Test
    public void getAll() throws IOException {
        System.out.println(crud.getAll(Unit.class));
    }

    @Test
    public void getById() throws IOException {
        Unit unit = new Unit();
        unit.setId(4L);
        System.out.println(crud.getById(unit.getId(), Unit.class));
    }

    @Test
    public void update() throws IOException {
        game.setTitle("YA NASRAL");
        game.setId(1L);
        System.out.println(crud.update(game));
    }

    @Test
    public void createArmy() throws IOException {

        System.out.println(crud.create(EntityGenerator.generateArmy()));
    }

    @Test
    public void deleteArmy() throws IOException {


        crud.delete(EntityGenerator.generateArmy());
    }
}