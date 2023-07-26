import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Service {}

public class Container {
    private Map<Class<?>, Object> dependencies;

    public Container() { dependencies = new HashMap<>(); }

    public void registerDependecy(Class<?> clazz,Object instance) {
        dependencies.put(clazz, instance);
    }

    public Object getDependency(Class<?> clazz) {
        return dependencies.get(clazz);
    }
}