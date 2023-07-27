package Assignment1;

import java.lang.reflect.Field;

public class MyDependencyInjector implements DependencyInjector{

    private Container container;

    public MyDependencyInjector(Container container) {
        this.container = container;
    }

    @Override
    public void injectDependencies(Object target) {
        Class<?> targetClass = target.getClass();
        Field[] fields = targetClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(MyInject.class)) {
                Class<?> dependencyClass = field.getType();
                Object dependency = container.resolveDependency(dependencyClass);

                if (dependency != null) {
                    try {
                        field.setAccessible(true);
                        field.set(target, dependency);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } else {
                    throw new RuntimeException("Dependency not found for field: " + field.getName());
                }
            }
        }
    }
}
