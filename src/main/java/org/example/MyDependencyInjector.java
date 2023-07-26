package org.example;

import java.lang.reflect.Field;

public class MyDependencyInjector implements DependencyInjector {
    @Override
    public void injectDependencies(Object target) throws InstantiationException, IllegalAccessException {

        Container container = new Container();

        Class<?> aClass = target.getClass();
        Field[] fields = aClass.getDeclaredFields();

       // container.registerDependency(UserRepository.class);


        for (Field field : fields) {

            boolean annotationPresent = field.isAnnotationPresent(CustomInjector.class);

            if (annotationPresent) {
                field.setAccessible(true);
                field.set(target, field.getType().newInstance());
//                Class<?> fieldType = field.getType();
//                Object fieldInstance =  Container.classObjectMap.get(fieldType);

//                try {
//                    //field.set(target, fieldInstance);
//                } catch (IllegalAccessException e) {
//                    throw new RuntimeException(e);
//                }


            }

        }
    }
}
