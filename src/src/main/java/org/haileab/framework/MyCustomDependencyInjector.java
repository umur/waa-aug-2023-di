package org.haileab.framework;

import java.lang.reflect.Field;
import java.util.List;

public class MyCustomDependencyInjector implements DependencyInjector{
    @Override
    public void injectDependecies(Object target) {
        Field[] fieldsName = target.getClass().getDeclaredFields();
        for(Field field: fieldsName){
            if(field.isAnnotationPresent(DI_HaileabWay.class)){
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
