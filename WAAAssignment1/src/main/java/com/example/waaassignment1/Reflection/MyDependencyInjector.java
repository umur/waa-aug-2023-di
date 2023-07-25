package com.example.waaassignment1.Reflection;

import java.lang.reflect.Field;

public class MyDependencyInjector implements DependencyInjector {
    private Container container;

    public MyDependencyInjector(Container container) {
        this.container = container;
    }

    public void injectDependencies(Object target) {
        Class<?> targetClass = target.getClass();
        Field[] fields = targetClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                try {
                    field.setAccessible(true);
                    Class<?> fieldType = field.getType();
                    Object dependency = container.getDependency(fieldType);
                    field.set(target, dependency);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
