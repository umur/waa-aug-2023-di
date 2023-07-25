import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class Container {
    private final Map<Class<?>, Object> dependencies;
    public Container() {
        dependencies = new HashMap<>();
    }
    public void registerDependency(Class<?> clazz) throws InstantiationException, IllegalAccessException {
        try {
            dependencies.put(clazz, clazz.getDeclaredConstructor().newInstance());
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public Object getDependency(Class<?> clazz) {
        return dependencies.get(clazz);
    }
}
