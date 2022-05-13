package ru.sfedu.PlanetGame.controllers;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.sfedu.PlanetGame.api.CRUD;
import ru.sfedu.PlanetGame.models.Game;
import ru.sfedu.PlanetGame.utils.HibernateUtil;

import java.io.IOException;
import java.util.List;

public class GameController {

    private CRUD crud = new CRUD();
    private Session session;


    private void initSession() throws IOException {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    private void closeSession() {
        if (session != null) {
            session.close();
        }
        session = null;
    }
    public Game create(Game game) throws IOException {
        return crud.create(game);
    }

    public List<Game> getAll() throws IOException {
        return crud.getAll(Game.class);
    }

    public Game getById(long id) throws IOException {
        return crud.getById(id, Game.class);
    }

    public void delete(Game game) throws IOException {
        crud.delete(game);
    }

    public Game update(Game game) throws IOException {
       return crud.update(game);
    }
}
