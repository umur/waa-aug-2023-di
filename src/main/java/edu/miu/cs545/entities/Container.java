package edu.miu.cs545.entities;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Container {

private Map<Class<?>, Object> classObjectMap;


    public Container() {
        this.classObjectMap = new HashMap<>();
    }


    public void registerDependency(Class<?> aClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object newInstance = aClass.getDeclaredConstructor().newInstance();
        this.classObjectMap.put(aClass, newInstance);
    }

    public Object getDependency(Class<?> clazz){
        return this.classObjectMap.get(clazz);
    }
}
