package org.example;

import java.util.HashMap;
import java.util.Map;

public class Container {
    private Map<Class<?>, Object> dependencies;

    public Container(){
        this.dependencies = new HashMap<>();
    }

    public <T> void registerDependency(Class<T> clazz, T instance) {
        dependencies.put(clazz, instance);
    }

    public <T> T getDependency(Class<T> clazz) {
        return clazz.cast(dependencies.get(clazz));
    }
}
