package lab1;

import java.util.HashMap;
import java.util.Map;

public class Container {
    private Map<Class<?>, Object> dependencies;

    public Container() {
        dependencies = new HashMap<>();
    }

    public void registerDependency(Class<?> clazz, Object instance) {
        dependencies.put(clazz, instance);
    }

    public Object getDependency(Class<?> clazz) {
        return dependencies.get(clazz);
    }
}