package assignment1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;


public class Container {
    private Map<Class<?>, Object> dependencies;

    public Container() {
        this.dependencies = new HashMap<>();
    }

    public void registerDependency(Class<?> clazz) {
        Constructor<?> con;
        try {
            con = clazz.getConstructor();
            dependencies.put(clazz, con.newInstance());

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public <T> T getDependency(Class<T> clazz) {
        return (T) dependencies.get(clazz);
    }
}
