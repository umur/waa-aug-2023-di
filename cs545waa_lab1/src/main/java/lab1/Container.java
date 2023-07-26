package lab1;

import java.util.HashMap;
import java.util.Map;

public class Container {

        private Map<Class<?>, Object> dependencies = new HashMap<>();

//        public void registerDependency(Class<?> clazz, Object dependency) {
//            dependencies.put(clazz, dependency);
//        }
public void registerDependency(Class<?> clazz) {
    try {
        Object instance = clazz.getDeclaredConstructor().newInstance();
        dependencies.put(clazz, instance);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

        public Object resolveDependency(Class<?> clazz) {
            return dependencies.get(clazz);
        }
    public Object getDependency(Class<?> clazz) {
        return dependencies.get(clazz);
    }
    }


