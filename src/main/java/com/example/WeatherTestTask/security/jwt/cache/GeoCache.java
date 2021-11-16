package com.example.WeatherTestTask.security.jwt.cache;

import java.util.Collections;
import java.util.Map;

public class GeoCache {
    private static volatile GeoCache instance;

    Map<String, String>
            map = Collections
            .singletonMap("key", "Value");

    private GeoCache() {
        System.out.println("GeoCache created!");
    }

    public static GeoCache getInstance() {
        if (instance == null) {
            synchronized (GeoCache.class) {
                if (instance == null) {
                    instance = new GeoCache();
                }
            }
        }
        return instance;
    }
}
