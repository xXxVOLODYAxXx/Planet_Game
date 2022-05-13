package ru.sfedu.PlanetGame.api;

import com.sun.net.httpserver.HttpServer;
import ru.sfedu.PlanetGame.Handlers.AttackPlanetHandler;
import ru.sfedu.PlanetGame.Handlers.CreateUniverseHandler;
import ru.sfedu.PlanetGame.Handlers.ManageResourcesHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HTTP {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello");
        HTTP.createHttpServer();
        System.out.println("End");
    }

    public static void createHttpServer() throws IOException {
        System.out.println("Server created");
        HttpServer server = HttpServer.create();
        server.bind(new InetSocketAddress(3001), 0);
        server.createContext("/createUniverse", new CreateUniverseHandler());
        server.createContext("/attackPlanet", new AttackPlanetHandler());
        //        server.createContext("/getEnemyPower", new CreateUniverseHandler());
        //        server.createContext("/getArmyPower", new CreateUniverseHandler());
        //        server.createContext("/deleteUniverse", new DeleteUniverseHandler());
        server.createContext("/manageResources", new ManageResourcesHandler());
        //        server.createContext("/hireUnit", new CreateUniverseHandler());
        //        server.createContext("/getBuildingInfo", new CreateUniverseHandler());
        //        server.createContext("/addBuilding", new CreateUniverseHandler());
        //        server.createContext("/removeBuilding", new CreateUniverseHandler());





        server.start();
    }
}


