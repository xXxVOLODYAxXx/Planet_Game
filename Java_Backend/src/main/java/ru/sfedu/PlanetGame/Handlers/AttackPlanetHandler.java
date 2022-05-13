package ru.sfedu.PlanetGame.Handlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import lombok.SneakyThrows;
import ru.sfedu.PlanetGame.api.CORE;
import ru.sfedu.PlanetGame.models.Game;
import ru.sfedu.PlanetGame.utils.QueryUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Map;

public class AttackPlanetHandler implements HttpHandler {
    private final CORE core = new CORE();



    @SneakyThrows
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println("aAAAAAAAAAAAAAAAAA");
        Map<String,String> map = QueryUtil.splitQuery(exchange.getRequestURI().getQuery());
        System.out.println(map);
        Long telegramId = Long.parseLong(map.get("telegramId"));
        System.out.println(telegramId);
        Long planetId = Long.parseLong(map.get("planetId"));
        System.out.println(planetId);
        byte[] bytes = attackPlanet(planetId,telegramId).getBytes();
        System.out.println("PIZDEC VSEMU");
        Headers headers = exchange.getResponseHeaders();
        headers.set("Content-Type", String.format("application/json; charset=%s", StandardCharsets.UTF_8));

        exchange.sendResponseHeaders(200, bytes.length);
        exchange.getResponseBody().write(bytes);
        exchange.getResponseBody().close();

    }



    private String getResponseMessage(String url) {
        return String.format("{\"message\": \"zdarova, pidr\", \"url\": \"%s\"}", url);
    }

    private String attackPlanet(Long planetId, Long telegramId) throws IOException, SQLException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Game result = core.attackPlanet(planetId,telegramId);
        if (result==null){

            return gson.toJson("LOOSE");
        } else if (result.getEnemyPlanetList().isEmpty()) {

            return gson.toJson("WIN");
        }else {
            return gson.toJson(result);
        }
    }
}
