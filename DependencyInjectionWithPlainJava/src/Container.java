import java.util.HashMap;
import java.util.Map;

public class Container {
    private final Map<Class<?>, Object> dependencies;

    Container(){
        dependencies = new HashMap<>();
    }

    public void registerDependencies(Class<?> clazz, Object instance){
        dependencies.put(clazz, instance);

    }
    public Object getInstance(Class<?> clazz){
        return dependencies.get(clazz);
    }
}
