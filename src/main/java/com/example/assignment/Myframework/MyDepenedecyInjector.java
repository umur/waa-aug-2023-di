package com.example.assignment.Myframework;

import java.lang.reflect.Field;

public class MyDepenedecyInjector implements DependecyInjector{
    @Override
    public void injectDependecies(Object target) {
        Field[] fieldsName = target.getClass().getDeclaredFields();
        for(Field field: fieldsName){
            if(field.isAnnotationPresent(TsiDai.class)){
                try {
                    field.setAccessible(true);
                    field.set(target, field.getType().newInstance());
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
