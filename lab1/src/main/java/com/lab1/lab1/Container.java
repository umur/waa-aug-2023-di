package com.lab1.lab1;


import java.util.HashMap;
import java.util.Map;

public class Container {
    private Map<Class<?>, Object> dependencyMap = new HashMap<>();

    public <T> void registerDependency(Class<T> clazz) {
        try {
            dependencyMap.put(clazz, clazz.newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Failed to create dependency instance", e);
        }
    }

    public Object getDependency(Class<?> clazz) {
        return dependencyMap.get(clazz);
    }
}
