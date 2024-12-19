package com.example.projectdata;

import java.util.HashMap;
import java.util.Map;

public class ProjectData {
    private final Map<String, Object> data = new HashMap<>();

    public void put(String key, Object value) {
        data.put(key, value);
    }

    public Object get(String key) {
        return data.get(key);
    }

    public Map<String, Object> getAll() {
        return new HashMap<>(data);
    }
}
