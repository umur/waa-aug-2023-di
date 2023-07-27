import java.util.HashMap;
import java.util.Map;

class Container {

    private Map<Class<?>, Object> dependencies = new HashMap<>();

    public void registerDependency(Class<?> clazz, Object instance) {
        dependencies.put(clazz, instance);
    }

    public Object getDependency(Class<?> clazz) {
        return dependencies.get(clazz);
    }
}