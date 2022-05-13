package ru.sfedu.PlanetGame.Handlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import ru.sfedu.PlanetGame.api.CORE;
import ru.sfedu.PlanetGame.models.Game;
import ru.sfedu.PlanetGame.utils.QueryUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class ManageResourcesHandler implements HttpHandler {
    private final CORE core = new CORE();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println("Я ЕБАНАТ");
        Map<String, String> map = QueryUtil.splitQuery(exchange.getRequestURI().getQuery());
        System.out.println(map);
        int operation = Integer.parseInt(map.get("operation"));
        System.out.println(operation);
        Long telegramId = Long.parseLong(map.get("telegramId"));
        System.out.println(telegramId);
        Long id = Long.parseLong(map.get("unitId"));
        System.out.println(id);
        byte[] bytes = manageResources(operation, telegramId, id).getBytes(); //Тут ебануть строку с юнитами
        System.out.println(bytes);
        Headers headers = exchange.getResponseHeaders();
        headers.set("Content-Type", String.format("application/json; charset=%s", StandardCharsets.UTF_8));

        exchange.sendResponseHeaders(200, bytes.length);
        exchange.getResponseBody().write(bytes);
        exchange.getResponseBody().close();

    }

    private String getResponseMessage(String url) {
        return String.format("{\"message\": \"zdarova, pidr\", \"url\": \"%s\"}", url);
    }

    private String manageResources(int operation, Long telegramId, Long id) throws IOException {
        Game game;
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        if (operation==1){
            game = core.manageResources(telegramId,operation);
            return gson.toJson(game);
        } else {
            game = core.manageResources(telegramId,operation, id);
            System.out.println("----------------------");
            System.out.println(game.getResources().getArmy().getArmyInfo());
            return gson.toJson(game);
        }
    }

}
