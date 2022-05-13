package ru.sfedu.PlanetGame.Handlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import ru.sfedu.PlanetGame.api.CORE;
import ru.sfedu.PlanetGame.api.HTTP;
import ru.sfedu.PlanetGame.models.Game;
import ru.sfedu.PlanetGame.utils.EntityGenerator;
import ru.sfedu.PlanetGame.utils.QueryUtil;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CreateUniverseHandler implements HttpHandler {
    private final CORE core = new CORE();
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Map map = QueryUtil.splitQuery(exchange.getRequestURI().getQuery());

        String telegramId = (String) map.get("telegramId");
        System.out.println(telegramId+"gffdgdfg");
        byte[] bytes = createUniverse(telegramId).getBytes();
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

    private String createUniverse(String telegramId) throws IOException {
        Game game = EntityGenerator.generateGame();
        core.createUniverse2(game,telegramId);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        System.out.println(gson.toJson(game));
        return gson.toJson(game);
    }

}