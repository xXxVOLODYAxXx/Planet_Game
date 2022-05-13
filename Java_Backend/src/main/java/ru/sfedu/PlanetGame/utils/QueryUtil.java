package ru.sfedu.PlanetGame.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class QueryUtil {
    public static Map<String, String> splitQuery(String url) throws UnsupportedEncodingException {
        final Map<String, String> query_pairs = new LinkedHashMap<String, String>();
        final String[] pairs = url.split("&");
        for (String pair : pairs) {
            final int idx = pair.indexOf("=");
            final String key = idx > 0 ? URLDecoder.decode(pair.substring(0, idx), "UTF-8") : pair;
            final String value = idx > 0 && pair.length() > idx + 1 ? URLDecoder.decode(pair.substring(idx + 1), "UTF-8") : null;
            query_pairs.put(key,value);
        }
        return query_pairs;
    }
}
