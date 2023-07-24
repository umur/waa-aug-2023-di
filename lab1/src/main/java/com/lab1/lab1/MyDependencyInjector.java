package com.lab1.lab1;


import java.lang.reflect.Field;

public class MyDependencyInjector implements DependencyInjector {

    private Container container;

    public MyDependencyInjector(Container container) {
        this.container = container;
    }

    @Override
    public void injectDependencies(Object target) {
        Field[] fields = target.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                Object dependency = container.getDependency(field.getType());
                if (dependency != null) {
                    field.setAccessible(true);
                    try {
                        field.set(target, dependency);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Failed to inject dependency", e);
                    }
                }
            }
        }
    }
}