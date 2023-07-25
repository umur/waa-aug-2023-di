package org.example;

import java.awt.*;
import java.lang.reflect.Field;

public class MyDependencyInjector implements DependencyInjector  {
    private Container container;

    public MyDependencyInjector(Container container){
        this.container = container;
    }
    @Override
    public void injectDependencies(Object target){
        Class<?> targetClass = target.getClass();

        Field[] fields = targetClass.getDeclaredFields();

        for(Field field: fields){
            if (field.isAnnotationPresent(InjectDependency.class)) {
                Object dependency = container.getDependency(field.getType());
                try {
                    field.setAccessible(true);
                    field.set(target, dependency);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
