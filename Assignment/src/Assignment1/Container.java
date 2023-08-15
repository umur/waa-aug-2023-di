package Assignment1;

import java.util.HashMap;
import java.util.Map;

public class Container {
    private Map<Class<?>, Object> dependencies = new HashMap<>();

    public void registerDependency(Class<?> clazz, Object instance){
        dependencies.put(clazz, instance);
    }

    public Object resolveDependency(Class<?> clazz) {
        return dependencies.get(clazz);
    }
}
