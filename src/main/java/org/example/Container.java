package org.example;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {

public static Map<Class<?>, Object> classObjectMap;

//private Class<?> clzz;

    public Container() {
        this.classObjectMap = new HashMap<>();
    }


    public void registerDependency(Class<?> clazz)  {
       // this.clzz = clazz;

        try {
            Object newInstance = clazz.getDeclaredConstructor().newInstance();
            this.classObjectMap.put(clazz, newInstance);
            //System.out.println(classObjectMap.get(clazz));
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }

    public Object getDependency(Class<?> clazz) {
       // System.out.println(" clazz " + this.clzz);
        return this.classObjectMap.get(clazz);
    }


}
